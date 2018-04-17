package com.summer.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.summer.shopping.Category;
import com.summer.shopping.Product;
import com.summer.shopping.util.DB;

public class ProductMysqlDAO implements ProductDAO{

	@Override
	public void addProduct(Product c) {
		Connection conn = DB.getConn();
		String sql = "insert into product values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getDescr());
			pstmt.setDouble(3, c.getNormalPrice());
			pstmt.setDouble(4, c.getMemberPrice());
			pstmt.setTimestamp(5, new Timestamp(c.getPdate().getTime()));
			pstmt.setInt(6, c.getCategoryID());
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(pstmt);
			DB.close(conn);
		}
	}

	@Override
	public boolean deleteProductsById(int[] id) {
		Connection conn = DB.getConn();
		String sql = "delete from product where id in (";
		Statement stmt = null;
		String strId = "";
		
		try {
			stmt = conn.createStatement();
			for(int i=0; i<id.length; i++) {
				if(i != id.length-1)
					strId += id[i]+",";
				else
					strId += id[i]+")";
			}
			sql += strId;
			
			System.out.println(sql);
			stmt.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DB.close(stmt);
			DB.close(conn);
		}
		
		return true;
	}

	@Override
	public boolean deleteProductsByCategoryId(int categoryId) {
		return false;
	}

	@Override
	public List<Product> getProducts(int pageNo, int pageSize) {
		List<Product> products = new ArrayList<Product>();
		Connection conn = DB.getConn();
		String sql = "select * from product limit "+(pageNo-1)*pageSize+","+pageSize;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalPrice(rs.getDouble("normalprice"));
				p.setMemberPrice(rs.getDouble("memberprice"));
				p.setPdate(rs.getTimestamp("pdate"));
				p.setCategoryID(rs.getInt("categoryid"));
				
				products.add(p);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		return products;
	}
	
	@Override
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		Connection conn = DB.getConn();
		String sql = "select * from product";
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalPrice(rs.getDouble("normalprice"));
				p.setMemberPrice(rs.getDouble("memberprice"));
				p.setPdate(rs.getTimestamp("pdate"));
				p.setCategoryID(rs.getInt("categoryid"));
				
				products.add(p);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		
		return products;
	}
	
	@Override
	public int getProducts(List<Product> products, int pageNo, int pageSize) {
		Connection conn = DB.getConn();
		String sql = "select p.id,p.name,p.descr,p.normalprice,p.memberprice,p.pdate,p.categoryid,"
						  + "c.id cid,c.name cname,c.descr cdescr,c.pid pid,c.isleaf,c.grade"
				+ " from product p join category c on(p.categoryid=c.id) limit "+(pageNo-1)*pageSize+","+pageSize;
System.out.println(sql);
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rsCount = null;
		
		int pageCount = 0;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalPrice(rs.getDouble("normalprice"));
				p.setMemberPrice(rs.getDouble("memberprice"));
				p.setPdate(rs.getTimestamp("pdate"));
				p.setCategoryID(rs.getInt("categoryid"));
				
				Category c = new Category();
				c.setId(rs.getInt("cid"));
				c.setName(rs.getString("cname"));
				c.setDescr(rs.getString("cdescr"));
				c.setPid(rs.getInt("pid"));
				c.setGrade(rs.getInt("grade"));
				if(rs.getInt("isleaf")==0) {
					c.setLeaf(true);
				} else {
					c.setLeaf(false);
				}
				p.setCategory(c);
				
				products.add(p);
			}

			rsCount = stmt.executeQuery("select count(*) from product");
			rsCount.next();
			pageCount = (rsCount.getInt(1)-1)/pageSize+1;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rsCount);
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		
		return pageCount;
	}

	@Override
	public int findProducts(List<Product> products, int[] categoryID, String keyword, double lowPrice, double highPrice,
			double lowMemberPrice, double highMemberPrice, Date startDate,
			Date endDate, int pageNo, int pageSize) {
		Connection conn = DB.getConn();
		String sql = "select * from product where 1=1 ";
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rsCount = null;
		int resultCount = 0;
		
		String strId = "";
		if(categoryID != null && categoryID.length > 0) {
			strId += "(";
			for(int i=0;i<categoryID.length;i++) {
				if(i<categoryID.length-1) {
					strId += categoryID[i]+",";
				} else {
					strId += categoryID[i];
				}
			}
			strId += ")";
			
			sql += "and categoryid in "+strId;
		}
		
		if(keyword != null && !keyword.trim().equals("")) {
			sql += " and name like '%"+keyword+"%' or descr like '%"+keyword+"%'";
		}
			
		if(lowPrice >= 0) {
			sql += "and normalprice > "+lowPrice;
		}
		
		if(highPrice > 0) {
			sql += "and normalprice < "+lowPrice;
		}
		
		if(lowMemberPrice >= 0) {
			sql += "and normalprice > "+lowMemberPrice;
		}
		
		if(highMemberPrice > 0) {
			sql += "and normalprice < "+lowMemberPrice;
		}
		
		if(startDate != null) {
			sql += "and pdate >= '"+new SimpleDateFormat("yyyy-MM-dd").format(startDate)+"'"; 
		}
		
		if(endDate != null) {
			sql += "and pdate <= '"+new SimpleDateFormat("yyyy-MM-dd").format(endDate)+"'"; 
		}
		
		String sqlCount = sql.replaceFirst("select \\*", "select count(*)");
System.out.println("sqlCount----"+sqlCount);
		
		sql += " limit "+(pageNo-1)*pageSize+","+pageSize;
System.out.println(sql);
		try {
			stmt = conn.createStatement();
			rsCount = stmt.executeQuery(sqlCount);
			rsCount.next();
			resultCount = rsCount.getInt(1);
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalPrice(rs.getDouble("normalprice"));
				p.setMemberPrice(rs.getDouble("memberprice"));
				p.setPdate(rs.getTimestamp("pdate"));
				p.setCategoryID(rs.getInt("categoryid"));
				
				products.add(p);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		
		return resultCount;
	}

	@Override
	public Product loadById(int id) {
		Connection conn = DB.getConn();
		String sql = "select p.id,p.name,p.descr,p.normalprice,p.memberprice,p.pdate,p.categoryid,"
						  + "c.id cid,c.name cname,c.descr cdescr,c.pid pid,c.isleaf,c.grade"
				+ " from product p join category c on(p.categoryid=c.id) where p.id="+id;
System.out.println(sql);
		Statement stmt = null;
		ResultSet rs = null;		
		
		Product p = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				p = new Product();
				
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalPrice(rs.getDouble("normalprice"));
				p.setMemberPrice(rs.getDouble("memberprice"));
				p.setPdate(rs.getTimestamp("pdate"));
				p.setCategoryID(rs.getInt("categoryid"));
				
				Category c = new Category();
				c.setId(rs.getInt("cid"));
				c.setName(rs.getString("cname"));
				c.setDescr(rs.getString("cdescr"));
				c.setPid(rs.getInt("pid"));
				c.setGrade(rs.getInt("grade"));
				if(rs.getInt("isleaf")==0) {
					c.setLeaf(true);
				} else {
					c.setLeaf(false);
				}
				p.setCategory(c);
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		
		return p;
	}

	@Override
	public boolean update(Product p) {
		Connection conn = DB.getConn();
		String sql = "update product set name=?,descr=?,normalprice=?,memberprice=?,categoryid=? where id="+p.getId();
		PreparedStatement pstmt = null;
		
		System.out.println(p.getId());
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getDescr());
			pstmt.setDouble(3, p.getNormalPrice());
			pstmt.setDouble(4, p.getMemberPrice());
			pstmt.setInt(5, p.getCategoryID());
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DB.close(pstmt);
			DB.close(conn);
		}
		return true;
	}

	@Override
	public List<Product> getLatestProducts(int count) {
		List<Product> products = new ArrayList<Product>();
		Connection conn = DB.getConn();
		String sql = "select * from product order by pdate desc limit 0,"+count;
		Statement stmt = null;
		ResultSet rs = null;
System.out.println(sql);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalPrice(rs.getDouble("normalprice"));
				p.setMemberPrice(rs.getDouble("memberprice"));
				p.setPdate(rs.getTimestamp("pdate"));
				p.setCategoryID(rs.getInt("categoryid"));
				
				products.add(p);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		
		return products;
	}

}
