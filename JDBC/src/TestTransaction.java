import java.sql.*;

public class TestTransaction {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1522:orcl","chg","tiger");
			
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.addBatch("insert into dept2 values(88,'feixiang','losanji')");
			stmt.addBatch("insert into dept2 values(89,'luzhan','sichuan')");
			stmt.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
		} catch(ClassNotFoundException e) {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch(SQLException e) {
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
