package com.shop.item.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.item.vo.CategoryVO;
import com.shop.item.vo.ImgVO;
import com.shop.item.vo.ItemVO;
import com.shop.item.vo.ItemViewVO;

@Service("itemService")   
public class ItemServiceImpl implements ItemService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<CategoryVO> selectCategoryList() {
		return sqlSession.selectList("selectCategoryList");
	}

	@Override
	public void insertCategory(CategoryVO categoryVO) {
		sqlSession.insert("insertCategory", categoryVO);
	}

	@Override
	public void deleteCategory(CategoryVO categoryVO) {
		sqlSession.delete("deleteCategory",categoryVO);
	}

	
			//rollbackFor = Exception.class 롤백시키는 타이밍을 예외상황발생시 로 지정 
	@Transactional(rollbackFor = Exception.class) //메소드 끝나고 오류가 없을때까지 기다렸다가 commit
	@Override
	public int insertItem(ItemVO itemVO,List<String> fileNameList) {
		//BOOK_ITEM테이블에 INSERT
		int result1 = sqlSession.insert("insertItem",itemVO);
 		
 		//이미지 정보를 저장할 객체 생성
 		List<ImgVO> imgList =  new ArrayList<>();
 		
 		//방금 등록된 상품의 itemcode를 가져옴
 		String itemCode = selectMaxItemCode();
 		
 		//다음 들어갈 이미지 정보의 번호를 가져옴.
 		int nextNumber = selectNextImgNumber();
 		
 		
 		
 		for(int i =0; i<fileNameList.size(); i++) {
 			ImgVO  vo = new ImgVO();
			vo.setImgName(fileNameList.get(i));
			//String.format("%03d", 5); //DB로 따지면 LPAD(5,3,0); 해당숫자5를 3자리로 맞추는데 모자라면 0으로 채우겠다.
			vo.setImgCode("IMG_"+String.format("%03d", nextNumber++));
			vo.setIsMain(i == 0 ? "Y" : "N" );
			vo.setItemCode(itemCode); 	
 			
 			imgList.add(vo);
 		}
 		ImgVO imgVO = new ImgVO();
 		imgVO.setImgList(imgList);
 		
 		int result2 = sqlSession.insert("insertImgs",imgVO);
 		return result1+result2;
	}

	
	
	
	
	
	
	@Override
	public List<ItemVO> selectItemList() {
		
		return sqlSession.selectList("selectItemList");
	}

	@Override
	public void insertImgs(ImgVO imgVO) {
		sqlSession.insert("insertImgs", imgVO);
	}

	@Override
	public int selectNextImgNumber() {
		return sqlSession.selectOne("selectNextImgNumber");
	}

	@Override
	public String selectMaxItemCode() {
		return sqlSession.selectOne("selectMaxItemCode");
	}

	
	
	//제품상세조회
	@Override
	public List<ItemViewVO> selectItemDetail(ItemViewVO itemViewVO) {
		return sqlSession.selectList("selectItemDetail",itemViewVO); 
	}

	@Override
	public List<ItemViewVO> selectSalesList(ItemViewVO itemViewVO) {
		return sqlSession.selectList("selectSalesList",itemViewVO);
	}

	@Override
	public int updateItemStock(ItemViewVO itemViewVO) {
		return sqlSession.update("updateItemStock",itemViewVO);
	}

	@Override
	public void updateItemPrice(ItemViewVO itemViewVO) {
		sqlSession.update("updateItemPrice",itemViewVO);
	}

	@Override
	public void updateItemStatus(ItemViewVO itemViewVO) {
		sqlSession.update("updateItemStatus",itemViewVO);
	}

	



	
	
}
