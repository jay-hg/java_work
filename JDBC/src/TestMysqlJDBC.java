import java.sql.*;

public class TestMysqlJDBC {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/mydata?user=root&password=tiger";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from dept");
			while(rs.next()) {
				System.out.println(rs.getInt(1));
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt = null;
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

}
