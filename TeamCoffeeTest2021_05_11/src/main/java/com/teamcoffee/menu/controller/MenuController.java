package com.teamcoffee.menu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.teamcoffee.cafe.vo.CafeVO;
import com.teamcoffee.menu.service.MenuService;
import com.teamcoffee.menu.vo.MenuCategoryVO;
import com.teamcoffee.menu.vo.MenuOptionGroupVO;
import com.teamcoffee.menu.vo.MenuOptionSelectedViewVO;
import com.teamcoffee.menu.vo.MenuOptionVO;
import com.teamcoffee.menu.vo.MenuVO;
import com.teamcoffee.menu.vo.MenuViewVO;
import com.teamcoffee.util.FileUploadUtil;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@Resource(name = "menuService")
	private MenuService menuService;
	
	//선택된 매장의 카테고리 받아오기
	@ResponseBody
	@PostMapping("/selectCafeCategoryList")
	public List<MenuCategoryVO> selectCafeCategoryList(CafeVO cafeVO){
		return menuService.selectCafeCategoryList(cafeVO);
	}
	
	//메뉴 등록
	@PostMapping("/insertMenu")
	public String insertMenu(MenuVO menuVO, HttpSession session, MultipartHttpServletRequest multi) {
		List<String> fileNameList = FileUploadUtil.prepareFileUpload(multi);
		int result = menuService.insertMenu(menuVO, fileNameList);
		
		if(result > 1) {
			FileUploadUtil.fileUpload(multi, fileNameList);
		}
		
		return "redirect:/owner/regMenu";
	}
	
	//카테고리 추가
	@ResponseBody
	@PostMapping("/insertCategory")
	public int insertCategory(MenuCategoryVO menuCategoryVO) {
		return menuService.insertCategory(menuCategoryVO);
	}
	
	//메뉴 목록 가져오기
	@ResponseBody
	@PostMapping("/selectMenuList")
	public List<MenuViewVO> selectMenuList(MenuVO menuVO){
		if(menuVO.getMenuCategoryCode() == null) {
			menuVO.setMenuCategoryCode("");
		}
		return menuService.selectMenuList(menuVO);
	}
	
	//메뉴 상세정보 조회
	@ResponseBody
	@PostMapping("/selectMenuDetail")
	public MenuViewVO selectMenuDetail(MenuVO menuVO) {
		return menuService.selectMenuDetail(menuVO);
	}

	//메뉴 정보 수정
	@ResponseBody
	@PostMapping("/updateMenuDetail")
	public int updateMenuDetail(MenuViewVO menuViewVO) {
		return menuService.updateMenuDetail(menuViewVO);
	}
	
	//메뉴 삭제
	@ResponseBody
	@PostMapping("/deleteMenu")
	public int deleteMenu(MenuVO menuVO) {
		return menuService.deleteMenu(menuVO);
	}
	
	//메뉴 옵션그룹 추가
	@ResponseBody
	@PostMapping("/insertOptionGroup")
	public int insertOptionGroup(MenuOptionGroupVO menuOptionGroupVO) {
		return menuService.insertOptionGroup(menuOptionGroupVO);
	}
	
	//메뉴 옵션그룹 호출
	@ResponseBody
	@PostMapping("/selectOptionGroupList")
	public List<MenuOptionGroupVO> selectOptionGroupList(MenuOptionGroupVO menuOptionGroupVO){
		return menuService.selectOptionGroupList(menuOptionGroupVO);
	}
	
	//메뉴 옵션그룹 삭제
	@ResponseBody
	@PostMapping("/deleteOptionGroup")
	public int deleteOptionGroup(MenuOptionGroupVO menuOptionGroupVO) {
		return menuService.deleteOptionGroup(menuOptionGroupVO);
	}
	
	//메뉴 옵션 추가
	@ResponseBody
	@PostMapping("/insertOption")
	public int insertOption(MenuOptionVO menuOptionVO) {
		return menuService.insertOption(menuOptionVO);
	}
	
	//메뉴 옵션 삭제
	@ResponseBody
	@PostMapping("/deleteOption")
	public int deleteOption(MenuOptionVO menuOptionVO) {
		return menuService.deleteOption(menuOptionVO);
	}
	
	//메뉴 옵션 타입 변경
	@ResponseBody
	@PostMapping("/updateOptionGroupType")
	public int updateOptionGroupType(MenuOptionGroupVO menuOptionGroupVO) {
		return menuService.updateOptionGroupType(menuOptionGroupVO);
	}
	
	//메뉴 옵션 리스트 호출
	@ResponseBody
	@PostMapping("/selectOptionList")
	public List<MenuOptionVO> selectOptionList(MenuOptionVO menuOptionVO){
		return menuService.selectOptionList(menuOptionVO);
	}
	
	//그룹이 있는 매장의 모든 메뉴 가져오기
	@ResponseBody
	@PostMapping("/selectGroupMenuList")
	public List<MenuVO> selectGroupMenuList(MenuOptionGroupVO menuOptionGroupVO){
		return menuService.selectGroupMenuList(menuOptionGroupVO);
	}
	
	//연결메뉴 추가
	@ResponseBody
	@PostMapping("/insertLinkMenu")
	public int insertLinkMenu(MenuOptionSelectedViewVO menuOptionSelectedViewVO) {
		return menuService.insertLinkMenu(menuOptionSelectedViewVO);
	}
	
	//연결된 메뉴 리스트 호출
	@ResponseBody
	@PostMapping("/selectLinkedMenuList")
	public List<MenuOptionSelectedViewVO> selectLinkedMenuList(MenuOptionVO menuOptionVO){
		return menuService.selectOptionSelectedList(menuOptionVO);
	}
	
	//연결메뉴 삭제
	@ResponseBody
	@PostMapping("/deleteLinkedMenu")
	public int deleteLinkedMenu(MenuOptionSelectedViewVO menuOptionSelectedViewVO) {
		return menuService.deleteLinkedMenu(menuOptionSelectedViewVO);
	}
}
