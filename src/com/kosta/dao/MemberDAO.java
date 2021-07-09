package com.kosta.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kosta.dto.MemberDTO;

public class MemberDAO {
	
	String className="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="hr";
	String pwd="hr";

	private ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
	//db 연결 메서드
	private Connection getConnection()
	{
		String className="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="hr";
		String pwd="hr";
		Connection conn=null;
		try {
			Class.forName(className);
			conn=DriverManager.getConnection(url,user,pwd);
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return conn;
	}
	
	public int ischeck(String mid) {
		Connection conn = getConnection();
		PreparedStatement pstmt=null;
		StringBuilder sql = new StringBuilder();
		sql.append("  select mid from member where mid=? ");
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, mid);
			result=pstmt.executeUpdate();
			
		}catch(SQLException e1) {
			System.out.println(e1);
		}finally {
			close(pstmt,conn);
		}
		return result;
	}//ischeck
	
	
	//insert 기능 메서드
	public int insert(String mid, String mname, String mpw, String memail) {
		Connection conn = getConnection();
		PreparedStatement pstmt=null;
		StringBuilder sql = new StringBuilder();
		sql.append("  insert into member(mno, mid, mpw, mname, memail)");
		sql.append("  values (membersequence.nextval, ?,?,?,?)  ");
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, mid);
			pstmt.setString(2, mpw);
			pstmt.setString(3, mname);
			pstmt.setString(4, memail);
			result=pstmt.executeUpdate();
			
		}catch(SQLException e1) {
			System.out.println(e1);
		}finally {
			close(pstmt,conn);
		}
		return result;
	}//insert
	
	//update 기능 메서드
	public int update(String mid, String mpw,String mname, String memail) {
		Connection conn = getConnection();
		PreparedStatement pstmt=null;
		StringBuilder sql = new StringBuilder();
		sql.append("  update member set mpw=?, mname=?, memail=?");
		sql.append(" where mid=? ");
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, mpw);
			pstmt.setString(2, mname);
			pstmt.setString(3, memail);
			pstmt.setString(4, mid);
			result=pstmt.executeUpdate();
			
		}catch(SQLException e1) {
			System.out.println(e1);
		}finally {
			close(pstmt,conn);
		}
		return result;
	}//update
	
	
	//delete 기능 메서드
	public int delete(String mid) {
		Connection conn = getConnection();
		PreparedStatement pstmt=null;
		StringBuilder sql = new StringBuilder();
		sql.append("  delete from member  ");
		sql.append(" where mid=? ");
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, mid);
			result=pstmt.executeUpdate();
			
		}catch(SQLException e1) {
			System.out.println(e1);
		}finally {
			close(pstmt,conn);
		}
		return result;
	}//delete
	
	
	
	//close 기능 메서드
	private void close(PreparedStatement pstmt, Connection conn){//pstmt,conn을 close하는 기능
		if(pstmt!=null) try { pstmt.close();} catch(SQLException e) {}
		if(conn!=null) try { conn.close();} catch(SQLException e) {}
	}
	
	
	
	//select 기능 메서드
	public ArrayList<MemberDTO>getAll() {
		Connection conn = getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
			Class.forName(className);
			conn=DriverManager.getConnection(url,user,pwd);
			StringBuilder sql = new StringBuilder();
		
		sql.append("  select mno, mid,mpw,mname,memail,mdate  ");
		sql.append(" from member order by mid ");
		
		pstmt=conn.prepareStatement(sql.toString());
		rs=pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.printf("%d\t %s\t %s\t  %s\t %s\t %s\n",rs.getInt("mno"),rs.getString("mid"), rs.getString("mpw"),rs.getString("mname"),rs.getString("memail"),rs.getString("mdate"));
			
		}//while
		//db연결해서 자료를 받아야함
		//자료구조 list, map, set  => ArrayList : db연결후에  ArrayList에 담아서 리턴
		
		
	}catch(ClassNotFoundException | SQLException e) {
		System.out.println(e);
	}
		return list;
	}//select
	
	
	//4. 선택 조회하기
	public ArrayList<MemberDTO>getselectAll(String mid) {
		Connection conn = getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
			Class.forName(className);
			conn=DriverManager.getConnection(url,user,pwd);
			StringBuilder sql = new StringBuilder();
		
		sql.append("  select mno, mid,mpw,mname,memail,mdate  ");
		sql.append(" from member  ");
		sql.append( "where mid=? ");
		
		pstmt=conn.prepareStatement(sql.toString());
		pstmt.setString(1, mid);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			System.out.printf("%d\t %s\t %s\t  %s\t %s\t %s\n",rs.getInt("mno"),rs.getString("mid"), rs.getString("mpw"),rs.getString("mname"),rs.getString("memail"),rs.getString("mdate"));
			
		}
		
		
	}catch(ClassNotFoundException | SQLException e) {
		System.out.println(e);
	}
		return list;
	}//4.select
	
	
	
	

}
