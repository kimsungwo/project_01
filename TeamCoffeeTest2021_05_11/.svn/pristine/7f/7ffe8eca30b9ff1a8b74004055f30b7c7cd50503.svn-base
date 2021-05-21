package com.teamcoffee.review.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.teamcoffee.buy.service.BuyService;
import com.teamcoffee.buy.vo.BuyVO;
import com.teamcoffee.buy.vo.BuyViewVO;
import com.teamcoffee.member.vo.MemberVO;
import com.teamcoffee.review.service.ReviewService;
import com.teamcoffee.review.vo.ReviewVO;
import com.teamcoffee.review.vo.ReviewViewVO;
import com.teamcoffee.util.FileUploadUtil;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	@Resource(name = "reviewService")
	private ReviewService reviewService;
	
	@Resource(name = "buyService")
	private BuyService buyService;
	
	@ResponseBody
	@PostMapping("/reviewForm")
	public List<BuyViewVO> reviewForm(BuyVO buyVO) {
	List<BuyViewVO> result = buyService.selectBuyDetailForReviewForm(buyVO);
		return result;
	}
	
	@PostMapping("/insertReview")
	public String insertReview(ReviewVO reviewVO, HttpSession session, MultipartHttpServletRequest multi) {
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		reviewVO.setMemCode(member.getMemCode());
		
		if(multi.getFile("file1") != null) {
			//첨부파일 업로드
			//경로설정
			String path = "D:\\workspaceSTS\\TeamCoffee\\src\\main\\webapp\\resources\\img\\review\\";
			//input태그에서 file명 받아오기
			MultipartFile file =  multi.getFile("file1");
			
			String fileName = FileUploadUtil.getNowDateTime() + "_" + file.getOriginalFilename();
			reviewVO.setReviewImg(fileName);
			
			//첨부파일 등록
			try {
				file.transferTo(new File(path + fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			reviewService.insertReview(reviewVO);
		}
		else {
			reviewService.insertReview(reviewVO);
		}
		
		return "redirect:/member/buyList";
	}
	
	@ResponseBody
	@PostMapping("/reviewListbyCafeCode")
	public List<ReviewViewVO> reviewListbyCafeCode(ReviewVO reviewVO) {
		List<ReviewViewVO> result = reviewService.reviewListbyCafeCode(reviewVO);
		return result;
	}
	
	@GetMapping("/deleteReview")
	public String deleteReview(ReviewVO reviewVO, HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		reviewVO.setMemCode(member.getMemCode());
		
		reviewService.deleteReview(reviewVO);
		return "redirect:/member/reviewList";
	}
	
	@ResponseBody
	@PostMapping("/selectReviewDetail")
	public List<ReviewViewVO> selectReviewDetail(ReviewVO reviewVO) {
		List<ReviewViewVO> result = reviewService.selectReviewDetail(reviewVO);
		return result;
	}
	
	@PostMapping("/updateReview")
	public String updateReview(ReviewVO reviewVO, MultipartHttpServletRequest multi) {
		if(multi.getFile("file1") != null) {
			//첨부파일 업로드
			//경로설정
			String path = "D:\\workspaceSTS\\TeamCoffee\\src\\main\\webapp\\resources\\img\\review\\";
			//input태그에서 file명 받아오기
			MultipartFile file =  multi.getFile("file1");
			
			String fileName = FileUploadUtil.getNowDateTime() + "_" + file.getOriginalFilename();
			reviewVO.setReviewImg(fileName);
			
			//첨부파일 등록
			try {
				file.transferTo(new File(path + fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			reviewService.updateReview(reviewVO);
		}
		else {
			reviewService.updateReview(reviewVO);
		}
		
		return "redirect:/member/reviewList";
	}
}
