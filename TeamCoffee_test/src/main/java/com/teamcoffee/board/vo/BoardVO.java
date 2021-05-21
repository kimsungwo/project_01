package com.teamcoffee.board.vo;

public class BoardVO {
	private int boardNum;
	private String boardName;
	private String boardContent;
	private String boardWriter;
	private String boardCode;
	private String boardRegDate;
	private String boardViewCnt;
	private String eventFromDate;
	private String eventToDate;
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}
	public String getBoardRegDate() {
		return boardRegDate;
	}
	public void setBoardRegDate(String boardRegDate) {
		this.boardRegDate = boardRegDate;
	}
	public String getBoardViewCnt() {
		return boardViewCnt;
	}
	public void setBoardViewCnt(String boardViewCnt) {
		this.boardViewCnt = boardViewCnt;
	}
	public String getEventFromDate() {
		return eventFromDate;
	}
	public void setEventFromDate(String eventFromDate) {
		this.eventFromDate = eventFromDate;
	}
	public String getEventToDate() {
		return eventToDate;
	}
	public void setEventToDate(String eventToDate) {
		this.eventToDate = eventToDate;
	}
}