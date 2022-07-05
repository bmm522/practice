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

public class memberservice {
	
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private String uid = "c##bmm522";
	private String upwd = "1234";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	// 이 클래스 내에서 계속 사용되야 할 것이므로 멤버변수로 지정.
	//드라이브를 실행할때마다 불러주고 그 해당 로직이 끝나면 종료되게끔 하기.(메모리부담 덜주기)
	public List<member> getMember(int checknumber) throws ClassNotFoundException, SQLException{
		int startUniqueNumber = 1+(checknumber-1)*3; //1, 4, 7, 10 ... 으로 가는 식
		int endUniqueNumber = checknumber*3;//3, 6, 9, 12 ... 으로가는 식
		String sql = "SELECT * FROM MEMBER WHERE UNIQUENUMBER BETWEEN ? AND ?";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, upwd);
		PreparedStatement st = con.prepareStatement(sql); // sql 구문에 값을 꽂아 넣기 위한 준비
		
		st.setInt(1, startUniqueNumber); // 첫번째 ?의 값에 꽂아 넣기
		st.setInt(2, endUniqueNumber); // 두번째 ?의 값에 꽂아 넣기
		
		ResultSet rs = st.executeQuery(); // 꽂아진 데이터를 사용하기 위해 ResultSet객체에 담기
		
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

	public int getTotal() throws ClassNotFoundException, SQLException {
		int totaldatacount = 0; // 데이터의 총 갯수를 담기위한 변수 선언
		
		String sql = "SELECT COUNT(UNIQUENUMBER) FROM MEMBER";
		//UNIQUENUMBER는 데이터의 갯수만큼 생성되기 때문에 UNIQUENUMBER을 카운트함.
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, upwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);//그 값을 객체에 담기 위해 사용
		
		rs.next(); //열이 하나밖에 없기때문에 한번만 탐색해도 괜찮음.
		
		totaldatacount=rs.getInt("COUNT(UNIQUENUMBER)"); 
		// 총 갯수의 값을 totaldatacount값에 담음.
		
		return totaldatacount;
	}
	
	
	
	
}
