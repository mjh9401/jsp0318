package 학생관리프로그램;

import java.sql.*;

public class Test03 {

	public static void main(String[] args) {
		String id = "myjsp";
		String password ="jsppassword";
		                  
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, password);
			
			ps = con.prepareStatement("insert into account values( '홍길동',acc_sq.nextval,'hong@naver.com',2000,sysdate)");
			ps.execute(); // commit;
			
			ps = con.prepareStatement("insert into account values( '고길동',acc_sq.nextval,'go@naver.com',5000,sysdate)");
			ps.execute(); // commit;
			
			ps = con.prepareStatement("insert into account values( '둘리',acc_sq.nextval,'dool@naver.com',1000,to_date('2018/02/27','yyyy/mm/dd'))");
			ps.execute(); // commit;
			
			System.out.println("레코드 추가완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(con != null){
					con.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}

