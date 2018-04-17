import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestScroll {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1522:orcl","chg","tiger");
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery("select * from emp order by sal");
		
		rs.next();
		System.out.println(rs.getInt(1));
		rs.last();
		System.out.println(rs.getInt(1));
		System.out.println(rs.isLast());
		System.out.println(rs.isAfterLast());
		System.out.println(rs.getRow());
		rs.previous();
		System.out.println(rs.getInt(1));
		rs.absolute(6);
		System.out.println(rs.getInt(1));
		
		rs.close();
		stmt.close();
		conn.close();
	}

}
