package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String className="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="hr";
		String pwd="hr";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
			Class.forName(className);
			conn=DriverManager.getConnection(url,user,pwd);
			StringBuilder sb = new StringBuilder();
			
			sb.append(" select				 ");
			sb.append("           bno        ");
			sb.append("           ,title     ");
			sb.append("           ,content   ");
			sb.append("           ,writer    ");
			sb.append("           ,readno    ");
			sb.append(" from board     ");
			sb.append(" order by bno     ");
			
			pstmt=conn.prepareStatement(sb.toString());
			rs=pstmt.executeQuery();
			
			//다음으로 넘어가는지 확인하기 위해)
			while(rs.next()) {
				System.out.printf("%d %s %s %s %d", rs.getInt("bno")
												  , rs.getString("title")
												  , rs.getString("content")
												  , rs.getString("writer")
												  , rs.getInt("readno"));
			}
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}finally {
			if(rs!=null) try { rs.close();} catch(SQLException e) {}
			if(pstmt!=null) try { pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try { conn.close();} catch(SQLException e) {}
		}
	}

}
