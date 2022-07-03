package study.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class program {
// 자바는 UI 레이아웃만, 데이터 가공처리는 SQL
// 트랜잭션 : 하나의 단위로 수행되길 바라는 쿼리의 묶음(=업무 수행단위, 논리적인 수행단위).
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "SELECT * FROM MEMBER";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "c##bmm522", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
		String id = rs.getString("ID");
		String pwd = rs.getString("PWD");
		String name = rs.getString("NAME");
		System.out.println();
		
		System.out.printf("%s, %s, %s", id, pwd, name);
		}
	}
}
