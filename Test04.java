package �л��������α׷�;

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
		System.out.print("�̸�: ");
		name = sc.next();
		System.out.print("�̸���: ");
		email = sc.next();
		
		String sql = "insert into account values('"+name+"',acc_sq.nextval,'"+email+"',1000,sysdate)";
		
		try {
			//Ŭ���� ã��
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//�ٸ� ����
			conn = DriverManager.getConnection(url, id, password);
			//������ �غ�
			ps = conn.prepareStatement(sql);
			//������ ����
			ps.execute();
			System.out.println("���ڵ� �߰� �Ϸ�!");
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
