package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
/*                                              ---리턴값-------
 * executeUpdate : insert,update,delete(dml) => int (row count) 몇개
 * 				   create,alter,drop (ddl) => 0
 * 
 * 
 */
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
			String title="안녕하세요";
			
			sb.append(" insert into board (bno,title,content,writer,readno) ");
			sb.append(" values(boardseq.nextval,?,?,?,0) ");
			pstmt=conn.prepareStatement(sb.toString());
			//pstmt.setInt(1, 10);
			pstmt.setString(1, title);
			pstmt.setString(2, "조금만 있으면 퇴근입니다.^^");
			pstmt.setString(3, "홍길동");
			int result=pstmt.executeUpdate();
				System.out.println("입력성공!!"+result);
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}finally {
			if(conn!=null) try { conn.close();} catch(SQLException e) {}
			if(conn!=null) try { conn.close();} catch(SQLException e) {}
		}
	}

}
