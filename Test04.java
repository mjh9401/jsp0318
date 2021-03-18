package 학생관리프로그램;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		String id = "myjsp";
		String password = "jsppassword";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn =null;
		PreparedStatement ps = null;
		
		String name, email;
		Scanner sc = new Scanner(System.in);
		System.out.print("이름: ");
		name = sc.next();
		System.out.print("이메일: ");
		email = sc.next();
		
		String sql = "insert into account values('"+name+"',acc_sq.nextval,'"+email+"',1000,sysdate)";
		
		try {
			//클래스 찾기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//다리 연결
			conn = DriverManager.getConnection(url, id, password);
			//쿼리문 준비
			ps = conn.prepareStatement(sql);
			//쿼리문 실행
			ps.execute();
			System.out.println("레코드 추가 완료!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
