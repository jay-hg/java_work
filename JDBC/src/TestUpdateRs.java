import java.sql.*;

public class TestUpdateRs {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1522:orcl","chg","tiger");
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery("select * from emp2");
		
		rs.updateString("ename", "AAAA");
		rs.updateRow();
		
		rs.moveToInsertRow();
		rs.updateInt(1, 9999);
		rs.updateString("ename", "xufan");
		rs.updateString("job", "ziyuan");
		rs.updateInt("MGR", 9888);
		rs.insertRow();
		
		rs.close();
		stmt.close();
		conn.close();
	}

}
