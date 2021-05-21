package com.shop.item.service;

import java.util.List;

import com.shop.item.vo.CategoryVO;
import com.shop.item.vo.ImgVO;
import com.shop.item.vo.ItemVO;
import com.shop.item.vo.ItemViewVO;

public interface ItemService {
	//카테고리 목록조회
	List<CategoryVO> selectCategoryList();
	
	//카테고리 추가삽입
	void insertCategory(CategoryVO categoryVO);
	
	//카테고리 삭제
	void deleteCategory(CategoryVO categoryVO);
	
	//제품등록
	int insertItem(ItemVO itemVO,List<String> fileNameList);
	
	//상품목록조회
	List<ItemVO> selectItemList();
	
	//상품이미지 추가(다중추가)
	void insertImgs(ImgVO imgVO);
	
	//이미지 테이블에 들어갈 다음 번호를 조회
	int selectNextImgNumber();
	
	//가장 큰 itemCode값을 조회
	String selectMaxItemCode();
	
	//제품상세조회
	List<ItemViewVO> selectItemDetail(ItemViewVO itemViewVO);
	
	//상품관리
	List<ItemViewVO> selectSalesList(ItemViewVO itemViewVO);
	
	//상품 재고 변경
	int updateItemStock(ItemViewVO itemViewVO);
	
	//상품가격 변경
	void updateItemPrice(ItemViewVO itemViewVO);
	
	//상품 판매상태변경
	void updateItemStatus(ItemViewVO itemViewVO);
}