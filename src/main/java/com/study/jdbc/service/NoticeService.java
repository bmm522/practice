package com.study.jdbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.study.jdbc.entity.Notice;

public class NoticeService {
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private String uid = "c##bmm522";
	private String upwd = "1234";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	
	public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException{
		int start = 1+(page-1)*3;
		int end = 3*page;
		
		String sql = "SELECT * FROM MEMBER_VIEW "
				+ "WHERE "+ field+ " LIKE ? AND NUM BETWEEN ? AND ?";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, upwd);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");
		st.setInt(2, start);
		st.setInt(3, end);
		ResultSet rs = st.executeQuery();
		
		
		List<Notice> list = new ArrayList<Notice>();
		while(rs.next()) {
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String name = rs.getString("NAME");
			int uniquenumber = rs.getInt("UNIQUENUMBER");
			
			Notice notice = new Notice(id, pwd, name, uniquenumber);
			
			list.add(notice);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
	
	//Scalar : 단위값
	public int getCount() throws ClassNotFoundException, SQLException {
		int count = 0;
		String sql = "SELECT COUNT(ID) FROM MEMBER";
			
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, upwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
			
		while(rs.next()){
		count = rs.getInt("COUNT(ID)");
		}
			
		return count;
	}
	
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		String id = notice.getId();
		String pwd = notice.getPwd();
		String name = notice.getName();
		
		
		
		
		String sql = "INSERT INTO member ("
				+ "    id,"
				+ "    pwd,"
				+ "    name "
				+ ") VALUES (?,?,?)";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, upwd);

		PreparedStatement st = con.prepareStatement(sql);
		
	   
	    
	    st.setString(1,  id);
	    st.setString(2, pwd);
	    st.setString(3, name);
		
		int result = st.executeUpdate();
		//결과 확인용
		
		st.close();
		con.close();
		
		return result;
		
	}
	
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		String id = notice.getId();
		String pwd = notice.getPwd();
		String name = notice.getName();
		int uniquenumber = notice.getUniquenumber();
		
		
		
		String sql = "UPDATE MEMBER "
				+ " SET"
				+ "    ID=?,"
				+ "    PWD=?, "
				+ " NAME=?"
				+ "WHERE UNIQUENUMBER=?";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, upwd);

		PreparedStatement st = con.prepareStatement(sql);
		
	   
	    
	    st.setString(1,  id);
	    st.setString(2, pwd);
	    st.setString(3, name);
	    st.setInt(4, uniquenumber);
		
		
		
	    int result = st.executeUpdate();
		//결과 확인용
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int delete(int uniquenumber) throws ClassNotFoundException, SQLException {
		String sql = "DELETE MEMBER WHERE UNIQUENUMBER=?";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, upwd);
	
		PreparedStatement st = con.prepareStatement(sql);
	
		st.setInt(1, uniquenumber);
	    int result = st.executeUpdate();
		
	 
		
		st.close();
		con.close();
		
		return result;
		
	}
	
	
}
