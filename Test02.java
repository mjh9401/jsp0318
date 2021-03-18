package �л��������α׷�;

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
			//�ٸ������
			connection = DriverManager.getConnection(url, id, password);
			
			//������ �غ�
			ps = connection.prepareStatement(sql);
			
			//������ ����
			ps.execute(); 
			System.out.println("Account ���̺� �����Ϸ�");
			
			ps = connection.prepareStatement("create sequence acc_sq nocache");
			ps.execute();
			System.out.println("acc_seq ������ �����Ϸ�!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					//������ �ݱ�
					ps.close(); //null.close() -> x
				}
				if(connection != null) {
					//�ٸ� �ݱ�
					connection.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
