import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDML {

	public static void main(String[] args) {
		Statement stmt = null;
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1522:orcl","chg","tiger");
			stmt = conn.createStatement();
			
			String sql = "insert into dept2 values(100,'ball','fuzhou')";
			stmt.executeUpdate(sql);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
				try {
					if (stmt != null)
						stmt.close();
					if (conn != null) 
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}

}
