package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String className="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="hr";
		String pwd="hr";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName(className);
			conn=DriverManager.getConnection(url,user,pwd);
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(" update board set title=?,content=? where bno=3 ");
			
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setString(1, "Hello");
			pstmt.setString(2, "즐거운 수업시간..");
			
			int result=pstmt.executeUpdate();
			
			if(result>=1)
				System.out.println("수정성공!!!");
			else
				System.out.println("수정실패");
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}finally {
			if(conn!=null) try { conn.close();} catch(SQLException e) {}
			if(conn!=null) try { conn.close();} catch(SQLException e) {}
		}
	}

}
