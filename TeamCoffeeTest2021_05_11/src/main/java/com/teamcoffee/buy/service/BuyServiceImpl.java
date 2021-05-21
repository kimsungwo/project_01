package com.teamcoffee.buy.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamcoffee.buy.vo.BuyDetailOptionVO;
import com.teamcoffee.buy.vo.BuyDetailVO;
import com.teamcoffee.buy.vo.BuyVO;
import com.teamcoffee.buy.vo.BuyViewVO;
import com.teamcoffee.cart.vo.CartViewVO;
import com.teamcoffee.member.vo.GradeVO;
import com.teamcoffee.member.vo.MemberVO;
import com.teamcoffee.member.vo.PointVO;

@Service("buyService")
public class BuyServiceImpl implements BuyService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public MemberVO selectBuyerInfo(MemberVO memberVO) {
		return sqlSession.selectOne("selectBuyerInfo", memberVO);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertBuyList(BuyVO buyVO) {
		
		//구매 테이블에 insert
		int result1 = sqlSession.insert("insertBuyList", buyVO);
		
		//구매 상세조회에 insert
		String buyCode = sqlSession.selectOne("selectMaxBuyCode");
		
		List<CartViewVO> buyMenus = sqlSession.selectList("selectBuyMenuList", buyVO);
		for(CartViewVO e : buyMenus) {
			BuyDetailVO bd = new BuyDetailVO();
			bd.setBuyCode(buyCode);
			bd.setMenuCode(e.getMenuCode());
			bd.setBuyQuantity(e.getBuyQuantity());
			bd.setBuyPrice(e.getCartPrice());
			sqlSession.insert("insertBuyMenu", bd);
			
			//상세 조회별 옵션 insert
			String buyDetailCode = sqlSession.selectOne("selectMaxBuyDetailCode");
			int nextDetailOptionNum = sqlSession.selectOne("selectMaxDetailOptionNum");
			
			List<BuyDetailOptionVO> buyDetailOptions = new ArrayList<>();
			
			List<CartViewVO> buyMenuDetails = sqlSession.selectList("selectBuyMenuDetailList", e);
			for(CartViewVO f : buyMenuDetails) {
				BuyDetailOptionVO bdo = new BuyDetailOptionVO();
				bdo.setBuyDetailOptionCode("BUY_DO_" + String.format("%03d", nextDetailOptionNum++));
				bdo.setBuyDetailCode(buyDetailCode);
				//옵션이 없는 경우는 코드가 0으로 설정되어 넘어감
				if(f.getMenuOptionCode().equals("0")) {
					continue;
				}
				bdo.setMenuOptionCode(f.getMenuOptionCode());
				buyDetailOptions.add(bdo);
			}
			BuyDetailOptionVO buyDetailOptionVO = new BuyDetailOptionVO();
			
			//옵션이 하나라도 들어간 경우
			if(buyDetailOptions.size() != 0) {
				buyDetailOptionVO.setBuyDetailOptions(buyDetailOptions);
				sqlSession.insert("insertBuyMenuOption", buyDetailOptionVO);
			}
		}
		
		return result1;
	}

	@Override
	public int selectCartCodeSize(MemberVO memberVO) {
		return sqlSession.selectOne("selectCartCodeSize", memberVO);
	}

	@Override
	public List<BuyViewVO> selectBuyList(MemberVO memberVO) {
		return sqlSession.selectList("selectBuyList", memberVO);
	}

	@Override
	public List<BuyViewVO> selectBuyListMenu(BuyVO buyVO) {
		return sqlSession.selectList("selectBuyListMenu", buyVO);
	}

	@Override
	public List<BuyViewVO> selectBuyDetail(BuyVO buyVO) {
		return sqlSession.selectList("selectBuyDetail", buyVO);
	}

	@Override
	public List<BuyViewVO> selectBuyDetailMenu(BuyVO buyVO) {
		return sqlSession.selectList("selectBuyDetailMenu", buyVO);
	}

	@Override
	public List<BuyViewVO> selectBuyDetailMenuOption(BuyDetailVO buyDetailVO) {
		return sqlSession.selectList("selectBuyDetailMenuOption", buyDetailVO);
	}


	@Override
	public List<BuyViewVO> selectBuyDetailForReviewForm(BuyVO buyVO) {
		return sqlSession.selectList("selectBuyDetailForReviewForm", buyVO);
	}
	
	@Override
	public int selectBuyPoint(BuyVO buyVO) {
		return (int)Optional.ofNullable(sqlSession.selectOne("selectBuyPoint", buyVO)).orElse(0);
	}

	@Override
	public int updateBuyStatus(BuyVO buyVO) {
		buyVO.setOrderMessage(Optional.ofNullable(buyVO.getOrderMessage()).orElse(""));
		return sqlSession.update("updateBuyStatus", buyVO);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int pointRefund(BuyVO buyVO) {
		int point = selectBuyPoint(buyVO);
		if(point == 0) {
			return 0;
		}
		else {
			PointVO pointVO = new PointVO();
			String memCode = sqlSession.selectOne("selectBuyMemCode", buyVO);
			pointVO.setMemCode(memCode);
			pointVO.setPointChangeName("결제 취소");
			pointVO.setPointChange(-point);
			pointVO.setBuyCode(buyVO.getBuyCode());
			sqlSession.insert("insertPointHistory", pointVO);
			MemberVO memberVO = new MemberVO();
			memberVO.setMemCode(memCode);
			memberVO.setMemPoint(-point);
			sqlSession.update("updateMemPoint", memberVO);
			return 1;
		}
		
		
	}
	
	@Override
	public int readMessage(BuyVO buyVO) {
		return sqlSession.update("readMessage", buyVO);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int pointSave(BuyVO buyVO) {
		System.out.println("@@@@@@" + buyVO.getBuyCode());
		BuyVO buy = sqlSession.selectOne("selectBuyMemCodeAndPrice", buyVO);
		buyVO.setMemCode(buy.getMemCode());
		String memGrade = sqlSession.selectOne("selectMemToGrade", buyVO);
		GradeVO gradeCode = new GradeVO();
		gradeCode.setGradeCode(memGrade);
		GradeVO grade = sqlSession.selectOne("seleceGradeInfo", gradeCode);
		int memPoint = (int)(buy.getTotalPrice() * grade.getGradePoint() / 100);
		
		MemberVO member = new MemberVO();
		member.setMemCode(buy.getMemCode());
		member.setMemPoint(memPoint);
		int result1 = sqlSession.update("updateMemPoint", member);
		
		PointVO point = new PointVO();
		point.setMemCode(buy.getMemCode());
		point.setPointChangeName("구매 적립");
		point.setPointChange(memPoint);
		point.setBuyCode(buyVO.getBuyCode());
		
		int result2 = sqlSession.insert("insertPointHistory", point);
		return result1 + result2;
	}
	
	
	
}
