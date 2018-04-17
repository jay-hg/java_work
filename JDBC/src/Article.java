import java.sql.*;

public class Article {

	public static void main(String[] args) {
		new Article().show();
	}
	
	public void show() {
		String url = "jdbc:mysql://localhost/bbs?user=root&password=tiger";
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from article where pid = 0");
			while (rs.next()) {
				System.out.println(rs.getString("cont"));
				tree(conn, rs.getInt("id"), 1);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
				rs.close();
				rs = null;
				}
				
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void tree(Connection conn, int id, int level) {
		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer preStr = new StringBuffer("");
		
		for (int i=0; i<level; i++) {
			preStr.append("        ");
		}
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from article where pid = "+id);
			while(rs.next()) {
				System.out.println(preStr+rs.getString("cont"));
				if(rs.getInt("isleaf") != 0) {
					tree(conn, rs.getInt("id"), level+1);
				} 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
				rs.close();
				rs = null;
				}
				
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

}
