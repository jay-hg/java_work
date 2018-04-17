package com.summer.shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.summer.shopping.util.DB;

public class CategoryDAO {
	
	public static void save(String name, String descr, int pid, int isLeaf, int grade) {
		if(pid != 0) {
			Connection conn = DB.getConn();
			String sql = "insert into category values(null,?,?,?,?,?)";
			PreparedStatement pstmt = null;
			Statement stmt = null;
			try {
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, name);
				pstmt.setString(2, descr);
				pstmt.setInt(3, pid);
				pstmt.setInt(4, isLeaf);
				pstmt.setInt(5, grade);
				pstmt.executeUpdate();
				
				stmt.executeUpdate("update category set isleaf=1 where id="+pid);
				
				conn.commit();
				conn.setAutoCommit(true);
				
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				DB.close(stmt);
				DB.close(pstmt);
				DB.close(conn);
			}
		} else {
			Connection conn = DB.getConn();
			String sql = "insert into category values(null,?,?,?,?,?)";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, descr);
				pstmt.setInt(3, pid);
				pstmt.setInt(4, isLeaf);
				pstmt.setInt(5, grade);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DB.close(pstmt);
				DB.close(conn);
			}
		}
	}
	
	private static void getCategories(Connection conn, List<Category> categories, int id) {
		String sql = "select * from category where pid="+id;
		ResultSet rs = null;
		try {
			rs = DB.getRs(conn, sql);
			while(rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescr(rs.getString("descr"));
				c.setPid(rs.getInt("pid"));
				c.setGrade(rs.getInt("grade"));
				if(rs.getInt("isleaf") == 0) {
					c.setLeaf(true);
				} else {
					c.setLeaf(false);
				}
				categories.add(c);
				
				if(rs.getInt("isleaf") != 0) {
					getCategories(conn, categories,c.getId());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
		}
	}
	
	public static void getCategories(List<Category> categories, int id) {
		Connection conn = DB.getConn();
		
		getCategories(conn,categories,id);
		DB.close(conn);
	}
	
	public static void delete(int id, int pid) {
		Connection conn = DB.getConn();
		String sql2 = "select count(id) from category where pid="+pid;
		Statement stmt2 = null;
		Statement stmt3 = null;
		ResultSet rs = null;
		try {
			conn.setAutoCommit(false);
			
			delete(conn,id);
			
			stmt2 = conn.createStatement();
			stmt3 = conn.createStatement();
			
			rs = stmt2.executeQuery(sql2);
			
			if(rs.next()) {
				if(rs.getInt(1) == 0) {
					stmt3.executeUpdate("update category set isleaf = 0 where id="+pid);
				}
			}
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DB.close(rs);
			DB.close(stmt3);
			DB.close(stmt2);
			DB.close(conn);
		}
	}
	
	private static void delete(Connection conn,int id) {
		String sql = "select * from category where pid ="+id;
		Statement stmt = null;
		Statement stmt2 = null; 
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			stmt2 = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				if(rs.getInt("isleaf") == 0) {
					delete(conn,rs.getInt("id"));
				}
			}
			stmt2.executeUpdate("delete from category where id ="+id);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt2);
			DB.close(stmt);
		}
	}
	
	public static Category loadById(int id) {
		Category c = new Category();
		Connection conn = DB.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from category where id="+id;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescr(rs.getString("descr"));
				c.setPid(rs.getInt("pid"));
				if(rs.getInt("isleaf") == 0) {
					c.setLeaf(true);
				} else {
					c.setLeaf(false);
				}
				c.setGrade(rs.getInt("grade"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		
		return c;
	}
	
	public static void update(Category c) {
		Connection conn = DB.getConn();
		String sql = "update category set name=?,descr=? where id ="+c.getId();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getDescr());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(pstmt);
			DB.close(conn);
		}
	}

	public static List<Category> getChildCategories(int parentId) {
		List<Category> children = new ArrayList<Category>();
		Connection conn = null;
	
		conn = DB.getConn();
		getCategories(conn,children,parentId);
		DB.close(conn);
		
		return children;
	}
}
