import java.sql.*;


public class TestProc {

	public static void main(String[] args) {
		Connection conn = null;
		CallableStatement cstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1522:orcl","chg","tiger");
			cstmt = conn.prepareCall("call p(?,?,?,?)");
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.registerOutParameter(4, Types.INTEGER);
			cstmt.setInt(1, 5);
			cstmt.setInt(2, 8);
			cstmt.setInt(4, 6);
			cstmt.execute();
			
			System.out.println(cstmt.getInt(3));
			System.out.println(cstmt.getInt(4));
		} catch( ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
