package com.teamcoffee.menu.service;

import java.util.List;

import com.teamcoffee.cafe.vo.CafeVO;
import com.teamcoffee.menu.vo.MenuCategoryVO;
import com.teamcoffee.menu.vo.MenuVO;
import com.teamcoffee.menu.vo.MenuViewVO;
import com.teamcoffee.owner.vo.OwnerVO;

public interface MenuService {
	
	//로그인 정보에 따라 매장 리스트 가져오기
	List<CafeVO> selectOwnersCafeList(OwnerVO ownerVO);
	
	//선택된 매장에 따라 카테고리를 받아오기
	List<MenuCategoryVO> selectCafeCategoryList(CafeVO cafeVO);
	
	//메뉴 및 메뉴 이미지 등록
	int insertMenu(MenuVO menuVO, List<String> fileNameList);
	
	//카테고리 추가
	int insertCategory(MenuCategoryVO menuCategoryVO);
	
	//메뉴 관리시 메뉴목록 가져오기
	List<MenuViewVO> selectMenuList(MenuVO menuVO);
	
	//메뉴 상세정보 가져오기
	MenuViewVO selectMenuDetail(MenuVO menuVO);
	
	//메뉴 정보 수정
	int updateMenuDetail(MenuViewVO menuViewVO);
}