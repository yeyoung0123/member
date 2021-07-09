package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String className="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="hr";
		String pwd="hr";
		
		Connection conn = null;
		try {
			Class.forName(className);
			conn=DriverManager.getConnection(url,user,pwd);
			System.out.println("데이터베이스 연결"+conn);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		}catch(SQLException e) {
			System.out.println(e);
		}
		finally {
			if(conn!=null)try { conn.close();} catch(SQLException e) {}
		}
	}

}
