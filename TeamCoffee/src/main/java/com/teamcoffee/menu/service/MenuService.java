package com.teamcoffee.menu.service;

import java.util.List;

import com.teamcoffee.cafe.vo.CafeVO;
import com.teamcoffee.menu.vo.MenuCategoryVO;
import com.teamcoffee.menu.vo.MenuOptionGroupVO;
import com.teamcoffee.menu.vo.MenuOptionSelectedViewVO;
import com.teamcoffee.menu.vo.MenuOptionVO;
import com.teamcoffee.menu.vo.MenuOptionViewVO;
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
	
	//메뉴 상세정보(+옵션그룹) 가져오기
	List<MenuOptionSelectedViewVO> selectMenuOptionDetail(MenuVO menuVO);
	
	//메뉴 상세정보(+옵션그룹 별 옵션들) 가져오기
	List<MenuOptionViewVO> selectMenuOptions(MenuOptionGroupVO menuOptionGroupVO);
	
	//메뉴 정보 수정
	int updateMenuDetail(MenuViewVO menuViewVO);
	
	//메뉴 삭제
	int deleteMenu(MenuVO menuVO);
	
	//옵션추가시 선택된 매장 정보
	CafeVO selectCafeInfoToOption(CafeVO cafeVO);
	
	//옵션 목록 가져오기
	List<MenuOptionGroupVO> selectOptionGroupList(MenuOptionGroupVO menuOptionGroupVO);
	
	//메뉴 옵션그룹 추가
	int insertOptionGroup(MenuOptionGroupVO menuOptionGroupVO);
	
	//메뉴 옵션그룹 삭제
	int deleteOptionGroup(MenuOptionGroupVO menuOptionGroupVO);
	
	//메뉴 옵션 목록 가져오기
	List<MenuOptionVO> selectOptionList(MenuOptionVO menuOptionVO);
	
	//메뉴 옵션 추가
	int insertOption(MenuOptionVO menuOptionVO);
	
	//메뉴 옵션 삭제
	int deleteOption(MenuOptionVO menuOptionVO);
	
	//옵션그룹 타입 변경
	int updateOptionGroupType(MenuOptionGroupVO menuOptionGroupVO);
	
	//옵션그룹 타입 가져오기
	MenuOptionGroupVO selectOptionGroupType(MenuOptionVO menuOptionVO);
	
	//옵션그룹별 연결된 메뉴 가져오기
	List<MenuOptionSelectedViewVO> selectOptionSelectedList(MenuOptionVO menuOptionVO);
	
	//그룹이 있는 매장의 모든 메뉴 가져오기
	List<MenuVO> selectGroupMenuList(MenuOptionGroupVO menuOptionGroupVO);
	
	//연결메뉴 추가
	int insertLinkMenu(MenuOptionSelectedViewVO menuOptionSelectedViewVO);
	
	//연결메뉴 삭제
	int deleteLinkedMenu(MenuOptionSelectedViewVO menuOptionSelectedViewVO);
	
	//메뉴옵션리스트
	List<MenuOptionViewVO> selectMenuOptionList(MenuVO menuVO);
	
}
