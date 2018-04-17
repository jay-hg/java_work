import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

public class TestDate {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/bbs?user=root&password=tiger";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select pdate from article");
			while(rs.next()) {
				Timestamp date = rs.getTimestamp("pdate");
				//SimpleDateFormat sdf = new SimpleDateFormat("yyyyƒÍMM‘¬dd»’");
				//System.out.println(sdf.format(date));
				
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				int m = c.get(Calendar.SECOND)+1;
				System.out.println(m);
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
