import java.sql.*;

public class TestBatch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1522:orcl","chg","tiger");
		/*Statement stmt = conn.createStatement();
		stmt.addBatch("insert into dept2 values(51,'meigong','shanghai')");
		stmt.addBatch("insert into dept2 values(52,'chengxuyuan','guangdong')");
		stmt.executeBatch();
		stmt.close();
		conn.close();*/
		
		PreparedStatement pstmt = conn.prepareStatement("insert into dept2 values(?, ?, ?)");
		pstmt.setInt(1, 68);
		pstmt.setString(2, "hepeng");
		pstmt.setString(3, "anxi");
		pstmt.addBatch();
		
		pstmt.setInt(1, 67);
		pstmt.setString(2, "haha");
		pstmt.setString(3, "feizhou");
		pstmt.addBatch();
		
		pstmt.executeBatch();
		pstmt.close();
		conn.close();
	}

}
