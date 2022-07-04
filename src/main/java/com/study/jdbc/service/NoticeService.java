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
	
	public List<Notice> getList() throws ClassNotFoundException, SQLException{
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "SELECT * FROM MEMBER";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "c##bmm522", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		
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
	
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		String id = notice.getId();
		String pwd = notice.getPwd();
		String name = notice.getName();
		
		
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "INSERT INTO member ("
				+ "    id,"
				+ "    pwd,"
				+ "    name "
				+ ") VALUES (?,?,?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "c##bmm522", "1234");

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
		
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "UPDATE MEMBER "
				+ " SET"
				+ "    ID=?,"
				+ "    PWD=?, "
				+ " NAME=?"
				+ "WHERE UNIQUENUMBER=?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "c##bmm522", "1234");

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
		
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "DELETE MEMBER WHERE UNIQUENUMBER=?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "c##bmm522", "1234");
	
		PreparedStatement st = con.prepareStatement(sql);
	
		st.setInt(1, uniquenumber);
	    int result = st.executeUpdate();
		
	 
		
		st.close();
		con.close();
		
		return result;
		
	}
}
