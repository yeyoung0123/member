package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
/*                                              ---���ϰ�-------
 * executeUpdate : insert,update,delete(dml) => int (row count) �
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
			String title="�ȳ��ϼ���";
			
			sb.append(" insert into board (bno,title,content,writer,readno) ");
			sb.append(" values(boardseq.nextval,?,?,?,0) ");
			pstmt=conn.prepareStatement(sb.toString());
			//pstmt.setInt(1, 10);
			pstmt.setString(1, title);
			pstmt.setString(2, "���ݸ� ������ ����Դϴ�.^^");
			pstmt.setString(3, "ȫ�浿");
			int result=pstmt.executeUpdate();
				System.out.println("�Է¼���!!"+result);
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}finally {
			if(conn!=null) try { conn.close();} catch(SQLException e) {}
			if(conn!=null) try { conn.close();} catch(SQLException e) {}
		}
	}

}
