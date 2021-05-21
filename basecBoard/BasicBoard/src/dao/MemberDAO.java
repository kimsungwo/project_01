package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.MemberDTO;
import oracle.net.aso.e;

//회원관련 쿼리문 여기서작성
public class MemberDAO {
	//회원가입
		Connection coon;
		PreparedStatement pstmt;
		String sql;
		ResultSet rs;
		public void join(MemberDTO member) {
			sql = "INSERT INTO BOARD_MEMBER "
					+ " VALUES (?,?,?)";
			try {
				coon=JDBCUtil.getConnection();
				pstmt=coon.prepareStatement(sql);
				//?값세팅 DTO를 매개변수에 넣어서  변수값으로 가져와서 세팅함.
				pstmt.setString(1,member.getMemberId());
				pstmt.setString(2,member.getPassword());
				pstmt.setString(3,member.getName());
				pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(pstmt, coon);
			}
		}
			public MemberDTO login(MemberDTO member) { //리턴자료형을 맞춰줌
				
				sql="SELECT MEMBER_ID, NAME"
						+" FROM BOARD_MEMBER"
						+" WHERE MEMBER_ID = ?"
						+" AND PASSWORD = ?";
				MemberDTO memberdto = new MemberDTO();		
				
				try {
					coon = JDBCUtil.getConnection();
					pstmt = coon.prepareStatement(sql);
					pstmt.setString(1,member.getMemberId());
					pstmt.setString(2, member.getPassword());
					rs = pstmt.executeQuery();
					
					//isSucess = rs.next();//보여줄 데이터가 없다 있다로 분류 true,false로만 정의함
					while(rs.next()) {//한줄씩 조회함
						memberdto.setMemberId(rs.getString("MEMBER_ID"));  //컬럼명""인걸 빼와서 객체에 세팅해줌
						memberdto.setName(rs.getString("NAME")); 
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
				JDBCUtil.close(rs, pstmt, coon);
			}	return memberdto; //true나  false임
				
	
	
	
	
	}
	
	
	//로그인
	//회원삭제

}
		
