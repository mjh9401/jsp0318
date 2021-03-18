package 학생관리프로그램;

import java.sql.*;


public class Test02 {
	public static void main(String[] args) {
		String id = "myjsp";
		String password = "jsppassword";
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String sql ="create table account(name varchar2(20),"
				+ " no number, "
				+ "email varchar2(20), "
				+ "point number, "
				+ "regdate date)";
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//다리만들기
			connection = DriverManager.getConnection(url, id, password);
			
			//쿼리문 준비
			ps = connection.prepareStatement(sql);
			
			//쿼리문 실행
			ps.execute(); 
			System.out.println("Account 테이블 생성완료");
			
			ps = connection.prepareStatement("create sequence acc_sq nocache");
			ps.execute();
			System.out.println("acc_seq 시퀀스 생성완료!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					//쿼리문 닫기
					ps.close(); //null.close() -> x
				}
				if(connection != null) {
					//다리 닫기
					connection.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
