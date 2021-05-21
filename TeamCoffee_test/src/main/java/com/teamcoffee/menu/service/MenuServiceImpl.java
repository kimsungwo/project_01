package com.teamcoffee.menu.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamcoffee.cafe.vo.CafeVO;
import com.teamcoffee.menu.vo.MenuCategoryVO;
import com.teamcoffee.menu.vo.MenuImgVO;
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
	public int updateMenuDetail(MenuViewVO menuViewVO) {
		return sqlSession.update("updateMenuDetail", menuViewVO);
	}

	
}