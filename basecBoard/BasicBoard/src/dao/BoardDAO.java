package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.BoardDTO;
import dto.MemberDTO;

public class BoardDAO {
	Connection coon;
	PreparedStatement pstmt;
	String sql;
	ResultSet rs;
	
	//게시글 등록메소드
	public void insertBoard(BoardDTO board) {
		sql=" INSERT INTO BOARD ("
				+ "BOARD_NUM"
				+ ", TITLE"
				+ ", CONTENT"
				+ ", MEMBER_ID"
				+ ") VALUES("
				+ "(SELECT NVL(MAX(BOARD_NUM)+1,1) FROM BOARD) "
				+ ",?,?,?)";
		try {
			coon=JDBCUtil.getConnection();
			pstmt=coon.prepareStatement(sql);
			pstmt.setString(1,board.getTitle());
			pstmt.setString(2,board.getContent());
			pstmt.setString(3,board.getMemberId());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace(); 
		}finally {
			JDBCUtil.close(pstmt, coon);
		}
		
		
		
		
	}
	//게시글 목록조회
	public List<BoardDTO> selectBoardList() {
		sql="SELECT BOARD_NUM, TITLE, MEMBER_ID, TO_CHAR(CREATE_DATE, 'YYYY-MM-DD') AS CREATE_DATE, READ_CNT "
				+"FROM BOARD ORDER BY BOARD_NUM DESC";
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			coon = JDBCUtil.getConnection();
			pstmt=coon.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO board = new BoardDTO(); //데이터를 보관해줄 객체를 만들어줌
				board.setBoardNum(rs.getInt("BOARD_NUM"));  //db에서받은 board_num값을 board의  boardnum에 세팅함
				board.setTitle(rs.getString("TITLE"));
				board.setMemberId(rs.getString("MEMBER_ID"));
				board.setCreateDate(rs.getString("CREATE_DATE"));
				board.setReadCnt(rs.getInt("READ_CNT"));
				list.add(board);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, coon);
		}
		return list;
	}
	//세부사항뷰 
	public BoardDTO selectBoardDetail(int boardNum) { //입력값은 매개변수로 받아오자. 변수명은 아무거나써도됨
		sql="SELECT BOARD_NUM,TITLE,CONTENT,MEMBER_ID,TO_CHAR(CREATE_DATE, 'YYYY-MM-DD') AS CREATE_DATE,READ_CNT,FILE_NAME "
				+ "FROM BOARD "
				+ "WHERE BOARD_NUM =?";
		BoardDTO board = new BoardDTO();
		try {
			coon = JDBCUtil.getConnection();
			pstmt = coon.prepareStatement(sql);
			pstmt.setInt(1,boardNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board.setBoardNum(rs.getInt("BOARD_NUM"));  //db에서받은 board_num값을 board의  boardnum에 세팅함
				board.setTitle(rs.getString("TITLE"));
				board.setContent(rs.getString("CONTENT"));
				board.setMemberId(rs.getString("MEMBER_ID"));
				board.setCreateDate(rs.getString("CREATE_DATE"));
				board.setReadCnt(rs.getInt("READ_CNT"));
				board.setFileName(rs.getString("FILE_NAME"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, coon);
		}
		return board;
	}
	//삭제
	public void delete(int boardNum) {
		sql="DELETE BOARD "
				+"WHERE BOARD_NUM = ?";
		
		try {
			coon= JDBCUtil.getConnection();
			pstmt=coon.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, coon);
		}
	}
	//게시글수정
	public void updateBoard(BoardDTO board1) {//?를 매개변수로 받아온다.
		sql="UPDATE BOARD "
				+"SET "
				+"TITLE =? "
				+", CONTENT =? "
				+"WHERE BOARD_NUM = ?";
		try {
			coon = JDBCUtil.getConnection();
			pstmt = coon.prepareStatement(sql);
			pstmt.setString(1, board1.getTitle());
			pstmt.setString(2, board1.getContent());
			pstmt.setInt(3, board1.getBoardNum());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();  
		}finally {
			JDBCUtil.close(pstmt, coon);
		}
	}
	//조회수증가
	public void read_cnt(int boardNum) {
		sql="UPDATE BOARD "
				+"SET READ_CNT = READ_CNT +1 "
				+"WHERE BOARD_NUM = ?";
		
		try {
			coon= JDBCUtil.getConnection();
			pstmt=coon.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, coon);
		}
	}
	
}
