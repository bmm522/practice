package study.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class program2 {
// 자바는 UI 레이아웃만, 데이터 가공처리는 SQL
// 트랜잭션 : 하나의 단위로 수행되길 바라는 쿼리의 묶음(=업무 수행단위, 논리적인 수행단위).
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		
		
		String id = "GHJTfd";
		String pwd = "4222";
		String name = "'주니어'";
		int uniquenumber = 7;
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "DELETE MEMBER WHERE UNIQUENUMBER=?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "c##bmm522", "1234");
		//Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql);
		//미리 sql문을 준비해서 할 수 있게함.
		
		// ResultSet rs = st.executeQuery(sql); 
		// SELECT할때 말고는 ResultSet객체를 담을 일이 없음.
//		st.setString(1, id);
//		st.setString(2, pwd);
//		st.setString(3, name);
		st.setInt(1, uniquenumber);
	    int result = st.executeUpdate();
		
	    System.out.println(result);
		
		
		
		
		st.close();
		con.close();
		
	}
}
