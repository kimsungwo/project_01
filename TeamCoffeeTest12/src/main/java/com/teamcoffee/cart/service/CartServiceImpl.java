package com.teamcoffee.cart.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamcoffee.cart.vo.CartOptionVO;
import com.teamcoffee.cart.vo.CartVO;
import com.teamcoffee.cart.vo.CartViewVO;

@Service("cartService")
public class CartServiceImpl implements CartService {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertCart(CartVO cartVO, CartOptionVO cartOptionVO) {
		int result1 = sqlSession.insert("insertCart", cartVO);
		int result2 = 0;
		String cartCode = sqlSession.selectOne("selectMaxCartCode");
		int nextNum = sqlSession.selectOne("selectMaxCartOptionNum");
		
		List<CartOptionVO> cartOptions = new ArrayList<>();
		List<String> options = new ArrayList<>();
		if(cartOptionVO.getRequiredOptions() != null) {
			options.addAll(cartOptionVO.getRequiredOptions());
		}
		if(cartOptionVO.getSelectionOptions() != null) {
			options.addAll(cartOptionVO.getSelectionOptions());
		}
		if(options.size() != 0) {
			for(String e : options) {
				CartOptionVO caop = new CartOptionVO();
				caop.setCartOptionCode("CART_OP_" + String.format("%03d", nextNum++));
				caop.setCartCode(cartCode);
				caop.setMenuOptionCode(e);
				cartOptions.add(caop);
			}
			cartOptionVO.setCartOptions(cartOptions);
			result2 = sqlSession.insert("insertCartOption", cartOptionVO);
		}
		return result1 + result2;
	}

	@Override
	public List<CartViewVO> selectCartList(CartVO cartVO) {
		return sqlSession.selectList("selectCartList", cartVO);
	}

	@Override
	public int updateBuyQuantity(CartVO cartVO) {
		return sqlSession.update("updateBuyQuantity", cartVO);
	}

	@Override
	public int deleteCart(CartVO cartVO) {
//		if(cartVO.getCartCode() == null) {
//			cartVO.setCartCode("");
//		}
		return sqlSession.delete("deleteCart", cartVO);
	}

	@Override
	public boolean isOverlabCart(CartVO cartVO) {
		String result1 = sqlSession.selectOne("checkCartToMemCode", cartVO);
		if(result1 == null) {
			return true;
		}
		
		String result2 = sqlSession.selectOne("checkCartToMenuCode", cartVO);
		
		if(result1.equals(result2)) {
			return true;
		}
		else {
			return false;
		}
	}
}
