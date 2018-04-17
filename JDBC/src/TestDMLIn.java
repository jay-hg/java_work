import java.sql.*;

public class TestDMLIn {

	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("please input 3 number");
			return;
		}
		
		int deptno = Integer.parseInt(args[0]);
		String dname = args[1];
		String loc = args[2];
		
		Statement stmt = null;
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1522:orcl","chg","tiger");
			stmt = conn.createStatement();
			
			String sql = "insert into dept2 values("+deptno+",'"+dname+"','"+loc+"')";
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
