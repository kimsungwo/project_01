package com.teamcoffee.board.vo;

public class PageVO {
	 private int nowPage;//현재 선택된 페이지
	   private int totalCnt;//전체 데이터 수(게시글 전체 수)
	   private int beginPage;//화면에 보이는 첫 페이지
	   private int endPage;//화면에 보이는 마지막 페이지
	   private int displayCnt;//한 번에 보여지는 게시글의 수
	   private int displayPageCnt;//한 번에 보여지는 페이지 수
	   private boolean prev;//prev 버튼 유무
	   private boolean next;//next 버튼 유무
	   private int startNum;//시작 row_num
	   private int endNum;//마지막 row_num
	   
	   public PageVO() {
	      nowPage = 1; //현재 페이지를 1로 설정
	      displayCnt = 10;//한 페이지에 5개의 게시글이 조회되게 설정
	      displayPageCnt = 10;
	   }
	
	   public int getDisplayCnt() {
		   return displayCnt;
	   }
	   
	   public void setNowPage(int nowPage) {
	      this.nowPage = nowPage;
	   }
	   
	   public int getNowPage() {
	      return nowPage;
	   }
	   
	   public void setStartNum() {
	      startNum = (nowPage - 1) * displayCnt + 1;
	   }
	   
	   public int getStartNum() {
	      return startNum;
	   }
	   
	   public void setEndNum() {
	      endNum = nowPage * displayCnt;
	   }
	   
	   public int getEndNum() {
	      return endNum;
	   }

	   public int getTotalCnt() {
	      return totalCnt;
	   }

	   public void setTotalCnt(int totalCnt) {
	      this.totalCnt = totalCnt;
	   }

	   public boolean getPrev() {
	      return prev;
	   }

	   public void setPrev(boolean prev) {
	      this.prev = prev;
	   }

	   public boolean getNext() {
	      return next;
	   }

	   public void setNext(boolean next) {
	      this.next = next;
	   }
	   
	   public int getBeginPage() {
	      return beginPage;
	   }

	   public int getEndPage() {
	      return endPage;
	   }

	   //이 메소드를 실행하면 페이지의 모든 정보를 세팅한다.
	   public void createPage() {
	      //화면에 보이는 마지막 페이지번호를 세팅
	      endPage = (int)(Math.ceil(nowPage / (double)displayPageCnt)) * displayPageCnt;
	      
	      //화면에 보이는 첫번째 페이지번호를 세팅
	      beginPage = endPage - displayPageCnt + 1;
	      
	      //전체 페이지 수
	      int totalPage = (int)(Math.ceil(totalCnt / (double)displayCnt));    
	      
	      //next버튼 유무
	      if(endPage < totalPage) {
	         next = true;
	      }
	      else {
	         next = false;
	         endPage = totalPage;
	      }
	      
	      //prev 버튼 유무
	      prev = beginPage == 1 ? false : true;
	      
	      //쿼리에서 조건절에 들어갈 데이터 범위 지정
	      setStartNum();
	      setEndNum();
	   
	   }
	   
	   
	
	
}