package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCUtil {

	//자바와 DB의 연결에 필요한 Connection객체 생성
	public static Connection getConnection() {
		Connection coon = null;
		
		try {Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			
		
		coon = ds.getConnection();
			
		}catch(Exception e) {
			System.out.println("ERROR! -> JDBCUtil : getConnection()메소드 에러");
			e.printStackTrace(); 
		}
		return coon;
	}
	//사용한 객체 소멸시키는 메소드 
	public static void close(ResultSet rs ,PreparedStatement pstmt, Connection coon) {
		try {			
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(coon!=null) {coon.close();}			
		}catch(Exception e) {
			System.out.println("ERROR! -> JDBCUtil : close()메소드 에러");
			e.printStackTrace(); 
		}
	}
	
	public static void close(PreparedStatement pstmt, Connection coon) {
		try {
			if(pstmt!=null) {pstmt.close();}
			if(coon!=null) {coon.close();}			
		}catch(Exception e) {
			System.out.println("ERROR! -> JDBCUtil : close()메소드 에러");
			e.printStackTrace(); 
		}
	}

}
