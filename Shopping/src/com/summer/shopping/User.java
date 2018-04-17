package com.summer.shopping;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.summer.shopping.util.DB;

public class User {
	private int id;
	private String username;
	private String password;
	private String phone;
	private String addr;
	private Date rdate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	
	public void save() {
		Connection conn = DB.getConn();
		String sql = "insert into user values(null,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, phone);
			pstmt.setString(4, addr);
			pstmt.setTimestamp(5, new Timestamp(rdate.getTime()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(pstmt);
			DB.close(conn);
		}
	}
	
	public static List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		Connection conn = DB.getConn();
		ResultSet rs = null;
		String sql = "select * from user";
		rs = DB.getRs(conn, sql);
		try {
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPhone(rs.getString("phone"));
				u.setAddr(rs.getString("addr"));
				u.setRdate(rs.getTimestamp("rdate"));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(conn);
		}
		return users;
	}
	
	public static void delete(int id) {
		Connection conn = DB.getConn();
		String sql = "delete from user where id="+id;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(stmt);
			DB.close(conn);
		}
	}
	
	public static User validate(String username, String password) throws UserNotFoundException, PasswordNotCorrectException {
		Connection conn = null;
		String sql = "select * from user where username='"+username+"'";
		ResultSet rs = null;
		User u = null;
		try {
			conn = DB.getConn();
			rs = DB.getRs(conn, sql);
			if(!rs.next()) {
				throw new UserNotFoundException();
			} else if(!rs.getString("password").equals(password)) {
				throw new PasswordNotCorrectException();
			} else {
				u = new User(); 
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPhone(rs.getString("phone"));
				u.setAddr(rs.getString("addr"));
				u.setRdate(rs.getTimestamp("rdate"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(conn);
		}
		
		return u;
	}
	
	public void update() {
		Connection conn = null;
		String sql = "update user set username=?,phone=?,addr=? where id="+this.id;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, phone);
			pstmt.setString(3, addr);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(pstmt);
			DB.close(conn);
		}
	}
	
	public static boolean usernameValidate(String username) {
		Connection conn = null;
		String sql = "select count(*) from user where username = '"+username+"'";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			stmt  = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				if(rs.getInt(1) <= 0) {
					return true;
				} 
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		return false;
	}
}
