package �л��������α׷�;

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
			// class.forname() => Ŭ������ ã�ڴ�
			// ã���鼭 + Ŭ���� �ε�(���α׷� ���� ����, �� Ŭ������ �޸𸮿� �ε�)
			Connection connection = DriverManager.getConnection(url, id, password);
			
			// connection : �ٸ� ������ ��ü
			
			PreparedStatement ps = connection.prepareStatement("CREATE SEQUENCE student_seq NOCACHE");
			// ������ �غ� �۾�
			ps.execute();
			// ����

			ps.close(); // ps ����
			connection.close(); // ��� 
			
			System.out.println("������ ���� �Ϸ�!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // OracleDriver Ŭ������ ���� �� �߻�
		} catch(SQLException e) {
			e.printStackTrace(); // Ŀ�ؼ�(DB ����)�ϴ� �������� ���� �߻�
		}
	}
}
