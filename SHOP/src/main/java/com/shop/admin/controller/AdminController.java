package com.shop.admin.controller;


import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.shop.buy.service.BuyService;
import com.shop.buy.vo.BuyViewVO;
import com.shop.item.service.ItemService;
import com.shop.item.vo.CategoryVO;
import com.shop.item.vo.ItemVO;
import com.shop.item.vo.ItemViewVO;
import com.shop.member.vo.MemberVO;
import com.shop.util.DateUtil;
import com.shop.util.FileUploadUtil;

@Controller
@RequestMapping("/admin") 
public class AdminController {
	
	@Resource(name="itemService") 
	private ItemService itemService;
	
	@Resource(name="buyService") //얘가 받는거임
	private BuyService buyService;
	
	
	//카테고리관리 페이지
	@GetMapping("/categoryManage")
	public String categoryManage(@RequestParam(name = "sideMenu",required = false, defaultValue = "1") String sideMenu,Model model) {
		//상품 카테고리 목록을 조회후 와야됨
		//model.addAttribute("categoryList",itemService.selectCategoryList());		
		model.addAttribute("sideMenu",sideMenu);	
		
		return "admin/category_manage";
	}
	//상품등록페이지
	@GetMapping("/insertItem")
	public String insertItem(@RequestParam(name = "sideMenu",required = false, defaultValue = "2")String sideMenu,Model model) {
		//상품 카테고리 목록을 조회후 와야됨
		//model.addAttribute("categoryList",itemService.selectCategoryList());		
		model.addAttribute("sideMenu",sideMenu);
		return "admin/item_form";
	}
	//카테고리추가삽입
	@PostMapping("/insertCategory")
	public String insertCategory(CategoryVO categoryVO, HttpSession session) {
		MemberVO memberVO = (MemberVO)session.getAttribute("loginInfo");
		categoryVO.setCreateUser(memberVO.getId());
		itemService.insertCategory(categoryVO);

		return "redirect:/admin/categoryManage";
	}
	//카테고리 삭제
	@GetMapping("/deleteCategory")
	public String deleteCategory(CategoryVO categoryVO) {
		itemService.deleteCategory(categoryVO);
		return "redirect:/admin/categoryManage";
	}
	//제품등록
	@PostMapping("/insertItem")
	public String insertItem(ItemVO itemVO, HttpSession session,MultipartHttpServletRequest multi) {//세션에서 유저를 끄집어내야됨
	
		//생성된 첨부파일명을 리스트로 들고옴
		List<String> fileNameList = FileUploadUtil.prepareFileUpload(multi);
		
		
		//상품등록
		MemberVO memberVO = (MemberVO)session.getAttribute("loginInfo");
		itemVO.setCreateUser(memberVO.getId()); 
		int result = itemService.insertItem(itemVO, fileNameList);
		
		//파일 첨부
		if(result>1) {
			FileUploadUtil.fileUpload(multi, fileNameList);
		}
	
		return "redirect:/admin/insertItem";
	}
	
	//@GetMapping("/salesManage")
	@RequestMapping("/salesManage")
	public String salesManage(@RequestParam(name = "sideMenu",required = false, defaultValue = "5")String sideMenu,Model model,BuyViewVO buyViewVO) {
		//model.addAttribute("categoryList",itemService.selectCategoryList());		
		model.addAttribute("sideMenu",sideMenu);
		
		//구매 목록 조회에 필요한 날짜 데이터를 저장한다.
		
		if(buyViewVO.getFromDate()==null) {
			//현재날짜 구하기
			String nowDate = DateUtil.getNowDateToString();
			
			//현재 달의 1일을 구하기
			String nowDateFirstDay = DateUtil.getNowDateFirstDayToString();
			buyViewVO.setFromDate(nowDateFirstDay);
			buyViewVO.setToDate(nowDate);
			
			System.out.println("!!!!!!!" + nowDate);
			System.out.println("!!!!!!!" + nowDateFirstDay);
			
		}
		//구매목록조회
		model.addAttribute("buyLog", buyService.buyLog(buyViewVO));
		//model.addAttribute("nowDate",nowDate);
		//model.addAttribute("nowDateFirstday",nowDateFirstDay);
		return "admin/sales_manage";
	}
	//상품 관리 검색포함
	//@GetMapping("/itemManage")
	@RequestMapping("/itemManage")
	public String itemManage(ItemViewVO itemViewVO,@RequestParam(name = "sideMenu",required = false, defaultValue = "3") String sideMenu,Model model) {
		model.addAttribute("sideMenu",sideMenu);
		if(itemViewVO.getItemStatuses() != null) {
			for(int e : itemViewVO.getItemStatuses()) {
				System.out.println("!!!!"+e);
			}
		}
		model.addAttribute("selectSalesList",itemService.selectSalesList(itemViewVO));
		System.out.println("!!!" + itemViewVO ); 
		return "admin/item_manage";
	}
	
	//이거 상품관리에서 재고만 수정하는 ajax
	@ResponseBody //일반적인 페이지이동이 아니라는걸 인식시켜주는것. ajax쓸땐 반드시 써줘야됨
	@PostMapping("/updateItemStock")
	public int updateItemStock(ItemViewVO itemViewVO) {
		return itemService.updateItemStock(itemViewVO);
	}
	
	//상품관리에서 가격만 수정하는 ajax
	@ResponseBody
	@PostMapping("/updateItemPrice")
	public void updateItemPrice(ItemViewVO itemViewVO) {
		itemService.updateItemPrice(itemViewVO);
	}
	
	//상품관리에서 판매상태만 수정하는 ajax
	@ResponseBody
	@PostMapping("/updateItemStatus")
	public void updateItemStatus(ItemViewVO itemViewVO) {
		itemService.updateItemStatus(itemViewVO);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
