package com.teamcoffee.cart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		List<CartOptionVO> cartOptions = new ArrayList<>();
		List<String> options = new ArrayList<>();
		if(cartOptionVO.getRequiredOptions() != null) {
			options.addAll(cartOptionVO.getRequiredOptions());
		}
		if(cartOptionVO.getSelectionOptions() != null) {
			options.addAll(cartOptionVO.getSelectionOptions());
		}
		
		//장바구니에 중복된 메뉴 확인
		List<CartVO> check1 = sqlSession.selectList("checkOverlabMenu", cartVO);
		//같은 메뉴가 담긴 cartCode가 있을시
		if(check1 != null) {
			//각각의 코드에 대해 같은 옵션인지 확인(cartCode 리스트로 검증)
			for(CartVO e : check1) {
				CartOptionVO co = new CartOptionVO();
				co.setCartCode(e.getCartCode());
				//cartCode로 조회한 menuOptionCode 리스트
				List<CartViewVO> cos = sqlSession.selectList("checkOverlabMenuOption", co);
				//사이즈를 우선 비교 -> 같으면 옵션코드를 비교
				if(cos.size() == options.size()) {
					HashMap<String, Integer> map = new HashMap<>();
					boolean isOverlab = true;
					for(CartViewVO f : cos) {
						//각 옵션코드를 key값에 넣고 value를 1로
						map.put(f.getMenuOptionCode(), map.getOrDefault(f.getMenuOptionCode(), 1));
					}
					//key값이 중복된 경우 value에 -1
					for(String g : options) {
						if(map.containsKey(g)) {
							map.put(g, map.get(g) - 1);
						}
					}
					//value가 모두 0이면 메뉴가 완전히 겹치므로 업데이트 가능
					for(Map.Entry<String, Integer> entry : map.entrySet()) {
						//하나라도 옵션이 다른 경우 중복여부에 false를 주고 for문을 빠져나감
						if(entry.getValue() > 0) {
							isOverlab = false;
							break;
						}
					}
					//모든 옵션의 중복일 경우 isOverlab은 true를 유지하여 update가능
					if(isOverlab) {
						cartVO.setCartCode(e.getCartCode());
						return sqlSession.update("updateCart", cartVO);
					}
				}
				else {
					break;
				}
			}
		}
		
		int result1 = sqlSession.insert("insertCart", cartVO);
		int result2 = 0;
		String cartCode = sqlSession.selectOne("selectMaxCartCode");
		int nextNum = sqlSession.selectOne("selectMaxCartOptionNum");
		
		
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
		return sqlSession.delete("deleteCart", cartVO);
	}

	@Override
	public boolean isOverlabCart(CartVO cartVO) {
		//memCode로 장바구니에 추가된 메뉴 확인
		String result1 = sqlSession.selectOne("checkCartToMemCode", cartVO);
		if(result1 == null) {
			return true;
		}
		
		//menuCode로 같은 매장인지 확인
		String result2 = sqlSession.selectOne("checkCartToMenuCode", cartVO);
		
		return result1.equals(result2) ? true : false;
	}
}
