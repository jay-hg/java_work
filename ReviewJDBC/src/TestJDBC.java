import java.sql.*;

public class TestJDBC {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		/*try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl","chg","tiger");
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
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
		
		
		/*try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl","chg","tiger");
			pstmt = conn.prepareStatement("insert into dept2 values(?,?,?)");
		
			pstmt.setInt(1, 10);
			pstmt.setString(2, "chengxuyuan");
			pstmt.setString(3, "fuzhou");
			pstmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl","chg","tiger");
			pstmt = conn.prepareStatement("insert into dept2 values(?,?,?)");
		
			conn.setAutoCommit(false);
			pstmt.setInt(1, 20);
			pstmt.setString(2, "gongchengshi");
			pstmt.setString(3, "xiamen");
			pstmt.addBatch();
			
			pstmt.setInt(1, 30);
			pstmt.setString(2, "zhuanjia");
			pstmt.setString(3, "beijing");
			pstmt.addBatch();
			pstmt.executeBatch();
			conn.setAutoCommit(true);
		} catch(ClassNotFoundException e) {
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
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
