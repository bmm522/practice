package com.practice.jdbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.practice.jdbc.entity.member;
import com.study.jdbc.entity.Notice;

public class memberservice {
	
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private String uid = "c##bmm522";
	private String upwd = "1234";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	// 이 클래스 내에서 계속 사용되야 할 것이므로 멤버변수로 지정.
	//드라이브를 실행할때마다 불러주고 그 해당 로직이 끝나면 종료되게끔 하기.(메모리부담 덜주기)
	public List<member> getMember() throws ClassNotFoundException, SQLException{
		
		String sql = "SELECT * FROM MEMBER";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, upwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<member> list = new ArrayList<member>(); //각자 테이블에서 추출한 값을 담아줄 리스트
		while(rs.next()) { //테이블의 마지막까지 탐색
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String name = rs.getString("NAME");
			int uniquenumber = rs.getInt("UNIQUENUMBER");
// ------------------여기까지 추출을 하고--------------------------
			
			member member = new member(id, pwd, name, uniquenumber); // member에 추출한 값 담기
			list.add(member); //담은 값을 리스트에 담기
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list; //테이블에서 추출한 값이 담긴 리스트
	}
	
	public void insert(member member) throws ClassNotFoundException, SQLException {
		String id = member.getId();
		String pwd = member.getPwd();
		String name = member.getName();
		//테이블 값을 꽂아넣을 변수 준비
		
		String sql = "INSERT INTO member ("
				+ "    id,"
				+ "    pwd,"
				+ "    name "
				+ ") VALUES (?,?,?)";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, upwd);
		PreparedStatement st = con.prepareStatement(sql);
		//쿼리에다가 데이터를 입력하는 거기때문에 굳이 객체에 담을 필요가 없어서 Preparedstatement 단계에서 sql구문 실행
		
		st.setString(1, id);
		st.setString(2, pwd);
		st.setString(3, name);
		//sql 구문에 꽂아넣기
		
		st.close();
		con.close();
		
		
	} 
	
	public void update(member member) throws ClassNotFoundException, SQLException {
		String id = member.getId();
		String pwd = member.getPwd();
		String name = member.getName();
		int uniquenumber = member.getUniquenumber(); // 수정해야하는 컬럼을 선택하기 위한 넘버
		
		
		
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
		
		
		
	  
		
		st.close();
		con.close();
		
		
	}
	public void delete(int uniquenumber) throws ClassNotFoundException, SQLException {
		String sql = "DELETE MEMBER WHERE UNIQUENUMBER=?";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, upwd);
		PreparedStatement st = con.prepareStatement(sql);
	
		st.setInt(1, uniquenumber);
	    
		st.close();
		con.close();
	}
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		memberservice ms = new memberservice();
		System.out.println(ms.getMember());
	}
}
