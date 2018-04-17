import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TestProStmt {
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("please input 3 number");
			return;
		}
		
		int deptno = Integer.parseInt(args[0]);
		String dname = args[1];
		String loc = args[2];
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1522:orcl","chg","tiger");
			pstmt = conn.prepareStatement("insert into dept2 values(?,?,?)");
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
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
		}
		
	}
}
