package 학생관리프로그램;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) {
		String id = "myjsp";
		String password = "jsppassword";
		String url = "jdbc:oracle:thin:@loaclhost:1521:xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			// class.forname() => 클래스를 찾겠다
			// 찾으면서 + 클래스 로드(프로그램 시작 전에, 이 클래스를 메모리에 로딩)
			Connection connection = DriverManager.getConnection(url, id, password);
			
			// connection : 다리 역할의 객체
			
			PreparedStatement ps = connection.prepareStatement("CREATE SEQUENCE student_seq NOCACHE");
			// 쿼리문 준비 작업
			ps.execute();
			// 실행

			ps.close(); // ps 정리
			connection.close(); // 통로 
			
			System.out.println("시퀀스 생성 완료!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // OracleDriver 클래스가 없을 때 발생
		} catch(SQLException e) {
			e.printStackTrace(); // 커넥션(DB 연동)하는 과정에서 예외 발생
		}
	}
}
