package com.teamcoffee.member.controller;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import com.teamcoffee.admin.service.AdminService;
import com.teamcoffee.admin.vo.QnAViewVO;
import com.teamcoffee.board.vo.BoardVO;
import com.teamcoffee.buy.service.BuyService;
import com.teamcoffee.buy.vo.BuyViewVO;
import com.teamcoffee.like.service.LikeService;
import com.teamcoffee.member.service.MemberService;
import com.teamcoffee.member.vo.MemberVO;
import com.teamcoffee.member.vo.PointVO;
import com.teamcoffee.review.service.ReviewService;
import com.teamcoffee.review.vo.ReviewVO;
import com.teamcoffee.util.FileUploadUtil;
import com.teamcoffee.util.sha256;


@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Resource(name = "memberService")
	private MemberService memberService;
	
	@Resource(name = "likeService")
	private LikeService likeService;
	
	@Resource(name = "buyService")
	private BuyService buyService;
	
	@Resource(name = "reviewService")
	private ReviewService reviewService;
	
	@Resource(name = "adminService")
	private AdminService adminService;
	
	@Autowired
	private JavaMailSender emailSender;
	
	//???????????? ???????????? ????????? ??????
	@GetMapping("/joinMember")
	public String joinMember() {
		return "member/join_form";
	}
	
	//????????? ????????????
	@ResponseBody
	@PostMapping("/memIdCheck")
	public void memIdCheck(MemberVO memberVO, HttpServletResponse response) throws IOException {
		int result = memberService.memIdCheck(memberVO);
		PrintWriter out = response.getWriter();
		if(result == 0) {
			out.print(true);
		}
		else if(result == 1) {
			out.print(false);
		}
	}
	
	//????????? ????????????
	@ResponseBody
	@PostMapping("/memEmailCheck")
	public void memEmailCheck(MemberVO memberVO, HttpServletResponse response) throws IOException {
		int result = memberService.memEmailCheck(memberVO);
		PrintWriter out = response.getWriter();
		if(result == 0) {
			out.print(true);
		}
		else if(result == 1) {
			out.print(false);
		}
	}

	//???????????? ???????????? ??????
	@PostMapping("/insertMember")
	public String insertMember(MemberVO memberVO, MultipartHttpServletRequest multi) {
		
		if(multi.getFile("file1") != null) {
			//???????????? ?????????
			//????????????
			String path = "D:\\workspaceSTS\\TeamCoffee\\src\\main\\webapp\\resources\\img\\profile\\";
			//input???????????? file??? ????????????
			MultipartFile file =  multi.getFile("file1");
			
			String fileName = FileUploadUtil.getNowDateTime() + "_" + file.getOriginalFilename();
			memberVO.setMemProfileImg(fileName);
			
			//???????????? ??????
			try {
				file.transferTo(new File(path + fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			memberService.insertMember(memberVO);
		}
		else {
			memberService.insertMember(memberVO);
		}
		
		
		return "redirect:/cafe/main";
	}
	
	//???????????? ????????? ??????
	@ResponseBody
	@PostMapping("/memberLoginProcess")
	public boolean memberLoginProcess(MemberVO memberVO, HttpSession session, HttpServletRequest request, HttpServletResponse response ,Model model) {
		String salt = memberService.getSaltByMemId(memberVO);
		if(salt == null) {
			return false;
		}
		else {
			String memPw = memberVO.getMemPw();
			
			memPw = sha256.getEncrypt(memPw, salt);
			memberVO.setMemPw(memPw);
			MemberVO memVO = memberService.memberLoginProcess(memberVO);
			if(memVO != null) {
				session.setAttribute("memberLoginInfo", memVO);
				
				if(request.getParameter("useCookie") != null) {
					//?????? ??????
					Cookie loginCookie = new Cookie("loginCookie", session.getId());
					loginCookie.setPath("/"); 
					loginCookie.setMaxAge(60*60*24*7);
					//?????? 
					response.addCookie(loginCookie);
				}
			}
			//????????? ????????? ????????? ??????
			if(memberVO.getUseCookie() != null) {
				int amount = 60 * 60 * 24 * 7;
				Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount)); //????????? ???????????? ??????
				memberService.keepLogin(memVO.getMemId(), session.getId(), sessionLimit);
			}
			return memVO != null ? true : false;
		}
	}
	
	//????????????
	@ResponseBody
	@PostMapping("/memberLogout")
	public void logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session.removeAttribute("memberLoginInfo");
		session.invalidate();
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		if(loginCookie != null) {
			loginCookie.setPath("/");
			loginCookie.setMaxAge(0);
			response.addCookie(loginCookie);
			memberService.keepLogin(session.getId(), "none", new Date());
		}
	}
	
	//???????????????
	@GetMapping("/myPage")
	public String profileManage(@RequestParam(name="sideMenu", required = false, defaultValue = "1") String sideMenu, MemberVO memberVO, HttpSession session,Model model) {
		model.addAttribute("sideMenu", sideMenu);
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
	
		model.addAttribute("memberInfo",memberService.memberInfo(member));
		return "member/board/profile_manage";
	}
	//??????????????? ??????????????????
	@PostMapping("/myPageUpdate")
	public String myPageUpdate(MemberVO memberVO, MultipartHttpServletRequest multi) {
		if(multi.getFile("file1") != null) {
			//???????????? ?????????
			//????????????
			String path = "D:\\workspaceSTS\\TeamCoffee\\src\\main\\webapp\\resources\\img\\profile\\";
			//input???????????? file??? ????????????
			MultipartFile file =  multi.getFile("file1");
			
			String fileName = FileUploadUtil.getNowDateTime() + "_" + file.getOriginalFilename();
			memberVO.setMemProfileImg(fileName);
			
			//???????????? ??????
			try {
				file.transferTo(new File(path + fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			memberService.myPageUpdate(memberVO);
		}
		else {
			memberService.myPageUpdate(memberVO);
		}
		return "redirect:/member/myPage";
	}
	
	//???????????? ????????? ??????
	@GetMapping("/toDropOutForm")
	public String toDropOutForm(@RequestParam(name="sideMenu", required = false, defaultValue = "7") String sideMenu, MemberVO memberVO, HttpSession session,Model model) {
		model.addAttribute("sideMenu", sideMenu);
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		model.addAttribute("memberInfo",memberService.memberInfo(member));
		return "member/board/to_drop_out";
	}
	//???????????? ??????
	@PostMapping("/toDropOut")
	public String toDropOut(MemberVO memberVO, HttpSession session,Model model) {
		String salt = memberService.getSaltByMemId(memberVO);
		String memPw = memberVO.getMemPw();
		//????????? ????????? ??????????????????????????? if????????? ????????? ????????????
		memPw = sha256.getEncrypt(memPw, salt);
		memberVO.setMemPw(memPw);
		MemberVO result = memberService.memberDropOut(memberVO);
		if(result != null) {
			memberService.leftMember(memberVO);
			session.removeAttribute("memberLoginInfo");
		}
		else {
			model.addAttribute("memberLoginInfo", result);
		}
		return "member/board/to_drop_out_result2";
	}
	
	//????????? ??????????????? ??????
	@GetMapping("/find_idForm")
	public String find_idForm() {
		 return "member/find_id";
	}
	
	//????????? ??????
	@PostMapping("/find_id")
	public String find_id(MemberVO memberVO,Model model){
		memberService.find_id(memberVO);
		model.addAttribute("findId",memberService.find_id(memberVO));
		return "member/find_id_result";
	}
	
	//???????????? ??????????????? ??????
	@GetMapping("/find_pwForm")
	public String find_pwForm(MemberVO memberVO,Model model) {
		model.addAttribute("memberVO",memberVO);
		return "member/find_pw";
	}
	
	//???????????? ??????
	@PostMapping("/find_pw")
	public String find_pw(MemberVO memberVO, Model model) {

		MemberVO memCodeFindResult = memberService.find_pw(memberVO);

		if (memCodeFindResult != null) {

			// ?????? ?????????
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper messageHelper;
			try {
				messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom("kswoo89@naver.com"); // ??????????????? ??????????????? ?????? ??????????????? ??????
				messageHelper.setTo(memberVO.getMemEmail()); // ???????????? ?????????
				messageHelper.setSubject("?????? ???????????? ??????"); // ??????????????? ????????? ????????????

				String RamdomPassword = memberService.getRamdomPassword();
				memberVO.setMemPw(RamdomPassword);
				memberService.pwUpdate(memberVO);

				String text = "???????????? ?????????????????????" + RamdomPassword + "?????????.";
				messageHelper.setText(text, true);
				emailSender.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("findPw", memCodeFindResult);
		return "member/find_pw_result";
	}
	//???????????? ?????????
	@GetMapping("/likeCafeList")
	public String likeCafeList(@RequestParam(name="sideMenu", required = false, defaultValue = "4") String sideMenu, Model model, HttpSession session) {
		model.addAttribute("sideMenu", sideMenu);
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		model.addAttribute("likeCafeList", likeService.likeCafeList(member.getMemCode()));
		return "member/board/like_cafe_list";
	}
	
	//?????? ??????????????? ??????
	@GetMapping("/memberMain")
	public String memberMain(@RequestParam(name="sideMenu", required = false, defaultValue = "1") String sideMenu, MemberVO memberVO, HttpSession session,Model model) {
		model.addAttribute("sideMenu", sideMenu);
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		model.addAttribute("memberInfo", memberService.memberInfo(member));
		model.addAttribute("members", memberService.selectMemberMainInfo(member));
		return "member/member_main";
	}
		
	//???????????? ?????????
	@GetMapping("/buyList")
	public String buyList(@RequestParam(name="sideMenu", required = false, defaultValue = "2") String sideMenu, Model model, HttpSession session) {
		model.addAttribute("sideMenu", sideMenu);
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		model.addAttribute("buyList", buyService.selectBuyList(member));
		return "member/board/buy_list";
	}
	
	//????????? ?????? ?????????
	@GetMapping("/pointList")
	public String pointList(@RequestParam(name="sideMenu", required = false, defaultValue = "3") String sideMenu, Model model, HttpSession session) {
		model.addAttribute("sideMenu", sideMenu);
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		member.setMemPoint(memberService.selectMemPoint(member));
		model.addAttribute("memberInfo", member);
		model.addAttribute("pointList", memberService.selectPointList(member));
		return "member/board/point_list";
	}

	
	//???????????? ?????????
	@GetMapping("/reviewList")
	public String reviewList(@RequestParam(name="sideMenu", required = false, defaultValue = "5") String sideMenu, ReviewVO reviewVO, HttpSession session, Model model) {
		model.addAttribute("sideMenu", sideMenu);
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		reviewVO.setMemCode(member.getMemCode());
		model.addAttribute("reviewList", reviewService.reviewListbyMemCode(reviewVO));
		return "member/board/review_list";
	}
	
	//QnA ?????????
	@GetMapping("/qnaMember")
	public String qnaMember(@RequestParam(name="sideMenu", required = false, defaultValue = "6") String sideMenu, Model model, QnAViewVO qnaViewVO, HttpSession session) {
		model.addAttribute("sideMenu", sideMenu);
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		qnaViewVO.setBoardWriter(member.getMemNickname());
		model.addAttribute("qnaList", memberService.selectQnAListToMember(qnaViewVO));
		return "member/board/qna_member";
	}
	
	//QnA ????????????
	@GetMapping("/qnaMemberDetail")
	public String qnaMemberDetail(@RequestParam(name="sideMenu", required = false, defaultValue = "6") String sideMenu, Model model, QnAViewVO qnaViewVO) {
		model.addAttribute("sideMenu", sideMenu);
		model.addAttribute("qnaDetail", adminService.selectDetailQnA(qnaViewVO));
		model.addAttribute("commentList", adminService.selectCommentQnA(qnaViewVO));
		return "member/board/qna_member_detail";
	}
	
	//QnA ?????? ???
	@GetMapping("/qnaMemberForm")
	public String qnaMemberForm(@RequestParam(name="sideMenu", required = false, defaultValue = "6") String sideMenu, Model model) {
		model.addAttribute("sideMenu", sideMenu);
		return "member/board/qna_member_form";
	}
	
	//QnA ??????
	@PostMapping("/qnaWrite")
	public String qnaWrite(BoardVO boardVO, HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		boardVO.setBoardWriter(member.getMemNickname());
		memberService.insertQnAMember(boardVO, member);
		return "redirect:/member/qnaMember";
	}
	
	//????????? ?????? ??????
	@ResponseBody
	@PostMapping("/insertPointHistory")
	public int insertPointHistory(HttpSession session, PointVO pointVO) {
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		pointVO.setMemCode(member.getMemCode());
		return memberService.insertPointHistory(pointVO);
	}
	
	//?????? ????????? ??????
	@ResponseBody
	@PostMapping("/updateMemPoint")
	public int updateMemPoint(HttpSession session, MemberVO memberVO) {
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		memberVO.setMemCode(member.getMemCode());
		return memberService.updateMemPoint(memberVO);
	}
	//?????? ?????? ??? ?????? ??????
	@ResponseBody
	@PostMapping("/checkMemberConfirm")
	public List<BuyViewVO> checkMemberConfirm(HttpSession session){
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		return memberService.checkMemberConfirm(member);
	}
	
	//?????? ??? ???????????? ??????
	@ResponseBody
	@PostMapping("/checkUnfinishedBuy")
	public boolean checkUnfinishedBuy(HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		return memberService.checkUnfinishedBuy(member);
	}
	
}
