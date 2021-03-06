package com.teamcoffee.menu.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamcoffee.cafe.vo.CafeVO;
import com.teamcoffee.menu.vo.MenuCategoryVO;
import com.teamcoffee.menu.vo.MenuImgVO;
import com.teamcoffee.menu.vo.MenuOptionGroupVO;
import com.teamcoffee.menu.vo.MenuOptionSelectedViewVO;
import com.teamcoffee.menu.vo.MenuOptionVO;
import com.teamcoffee.menu.vo.MenuOptionViewVO;
import com.teamcoffee.menu.vo.MenuVO;
import com.teamcoffee.menu.vo.MenuViewVO;
import com.teamcoffee.owner.vo.OwnerVO;

@Service("menuService")
public class MenuServiceImpl implements MenuService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<CafeVO> selectOwnersCafeList(OwnerVO ownerVO) {
		return sqlSession.selectList("selectOwnersCafeList", ownerVO);
	}

	@Override
	public List<MenuCategoryVO> selectCafeCategoryList(CafeVO cafeVO) {
		return sqlSession.selectList("selectCafeCategoryList", cafeVO);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertMenu(MenuVO menuVO, List<String> fileNameList) {
		int result1 = sqlSession.insert("insertMenu", menuVO);
		
		String menuCode = sqlSession.selectOne("selectMaxMenuCode");
		
		MenuImgVO menuImg = new MenuImgVO();
		menuImg.setMenuCode(menuCode);
		menuImg.setMenuImgName(fileNameList.get(0));
		
		int result2 = sqlSession.insert("insertMenuImg", menuImg);
		
		return result1 + result2;
	}

	@Override
	public int insertCategory(MenuCategoryVO menuCategoryVO) {
		return sqlSession.insert("insertCategory", menuCategoryVO);
	}

	@Override
	public List<MenuViewVO> selectMenuList(MenuVO menuVO) {
		return sqlSession.selectList("selectMenuList", menuVO);
	}

	@Override
	public MenuViewVO selectMenuDetail(MenuVO menuVO) {
		return sqlSession.selectOne("selectMenuDetail", menuVO);
	}

	@Override
	public List<MenuOptionSelectedViewVO> selectMenuOptionDetail(MenuVO menuVO) {
		return sqlSession.selectList("selectMenuOptionDetail", menuVO);
	}
	
	@Override
	public int updateMenuDetail(MenuViewVO menuViewVO) {
		return sqlSession.update("updateMenuDetail", menuViewVO);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteMenu(MenuVO menuVO) {
		int result1 = sqlSession.delete("deleteMenuWithOption", menuVO);
		int result2 = sqlSession.delete("deleteMenuImg", menuVO);
		int result3 = sqlSession.delete("deleteMenu", menuVO);
		return result1 + result2 + result3;
	}

	@Override
	public List<MenuOptionGroupVO> selectOptionGroupList(MenuOptionGroupVO menuOptionGroupVO) {
		return sqlSession.selectList("selectOptionGroupList", menuOptionGroupVO);
	}

	@Override
	public CafeVO selectCafeInfoToOption(CafeVO cafeVO) {
		return sqlSession.selectOne("selectCafeInfoToOption", cafeVO);
	}

	@Override
	public int insertOptionGroup(MenuOptionGroupVO menuOptionGroupVO) {
		return sqlSession.insert("insertOptionGroup", menuOptionGroupVO);
	}

	@Override
	public int deleteOptionGroup(MenuOptionGroupVO menuOptionGroupVO) {
		return sqlSession.delete("deleteOptionGroup", menuOptionGroupVO);
	}

	@Override
	public List<MenuOptionVO> selectOptionList(MenuOptionVO menuOptionVO) {
		return sqlSession.selectList("selectOptionList", menuOptionVO);
	}

	@Override
	public int insertOption(MenuOptionVO menuOptionVO) {
		return sqlSession.insert("insertOption", menuOptionVO);
	}

	@Override
	public int deleteOption(MenuOptionVO menuOptionVO) {
		return sqlSession.delete("deleteOption", menuOptionVO);
	}

	@Override
	public int updateOptionGroupType(MenuOptionGroupVO menuOptionGroupVO) {
		return sqlSession.update("updateOptionGroupType", menuOptionGroupVO);
	}

	@Override
	public MenuOptionGroupVO selectOptionGroupType(MenuOptionVO menuOptionVO) {
		return sqlSession.selectOne("selectOptionGroupType", menuOptionVO);
	}

	@Override
	public List<MenuOptionSelectedViewVO> selectOptionSelectedList(MenuOptionVO menuOptionVO) {
		return sqlSession.selectList("selectOptionSelectedList", menuOptionVO);
	}

	@Override
	public List<MenuOptionViewVO> selectMenuOptions(MenuOptionGroupVO menuOptionGroupVO) {
		return sqlSession.selectList("selectMenuOptions", menuOptionGroupVO);
	}
	
	@Override
	public List<MenuVO> selectGroupMenuList(MenuOptionGroupVO menuOptionGroupVO) {
		return sqlSession.selectList("selectGroupMenuList", menuOptionGroupVO);
	}

	@Override
	public int insertLinkMenu(MenuOptionSelectedViewVO menuOptionSelectedViewVO) {
		return sqlSession.insert("insertLinkMenu", menuOptionSelectedViewVO);
	}

	@Override
	public int deleteLinkedMenu(MenuOptionSelectedViewVO menuOptionSelectedViewVO) {
		return sqlSession.delete("deleteLinkedMenu", menuOptionSelectedViewVO);
	}
	
	@Override
	public List<MenuOptionViewVO> selectMenuOptionList(MenuVO menuVO) {
		return sqlSession.selectList("selectMenuOptionList", menuVO);
	}


	
	
}
