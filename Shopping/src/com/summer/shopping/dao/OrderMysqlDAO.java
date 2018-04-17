package com.summer.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import com.summer.shopping.Cart;
import com.summer.shopping.CartItem;
import com.summer.shopping.Order;
import com.summer.shopping.Product;
import com.summer.shopping.User;
import com.summer.shopping.util.DB;

public class OrderMysqlDAO implements OrderDAO{

	@Override
	public void saveOrder(Order o) {
		Connection conn = DB.getConn();
		String sql = "insert into salesorder values(null,?,?,?,?)";
		PreparedStatement pstmt = null;
		PreparedStatement pstmtI = null;
		ResultSet rsKey = null;
		
		List<CartItem> items = o.getCart().getCartItems();
		CartItem ci = null;
		
		try {
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1,o.getUser().getId());
			pstmt.setString(2, o.getAddr());
			pstmt.setTimestamp(3, new Timestamp(o.getOdate().getTime()));
			pstmt.setInt(4, o.getStatus());
			
			pstmt.executeUpdate();
			rsKey = pstmt.getGeneratedKeys();
			rsKey.next();
			int id = rsKey.getInt(1);
			String sqlItem = "insert into salesitem values(null,?,?,?,"+id+")";
			
			pstmtI = conn.prepareStatement(sqlItem);
			for(int i=0; i<items.size(); i++) {
				ci = items.get(i);
				pstmtI.setInt(1, ci.getProduct().getId());
				pstmtI.setDouble(2, ci.getPrice());
				pstmtI.setInt(3, ci.getCount());
				
				pstmtI.addBatch();
			}
			pstmtI.executeUpdate();
			
			conn.setAutoCommit(true);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rsKey);
			DB.close(pstmt);
			DB.close(pstmtI);
			DB.close(conn);
		}
	}

	@Override
	public int getOrders(List<Order> orders, int pageNo, int pageSize) {
		Connection conn = DB.getConn();
		String sql = "select o.id,o.addr,o.odate,o.status,"
						  + "u.id,u.username,u.password,u.phone,u.addr,u.rdate "
						  + "from salesorder o join user u on(o.userid=u.id)"
						  + " limit "+(pageNo-1)*pageSize+","+pageSize;
System.out.println(sql);
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rsCount = null;
		
		int pageCount = 0;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt("u.id"));
				u.setUsername(rs.getString("u.username"));
				u.setPassword(rs.getString("u.password"));
				u.setPhone(rs.getString("u.phone"));
				u.setAddr(rs.getString("u.addr"));
				u.setRdate(rs.getTimestamp("u.rdate"));
				
				Order o = new Order();
				o.setUser(u);
				o.setId(rs.getInt("o.id"));
				o.setAddr(rs.getString("o.addr"));
				o.setOdate(rs.getTimestamp("o.odate"));
				o.setStatus(rs.getInt("o.status"));
				
				orders.add(o);
			}

			rsCount = stmt.executeQuery("select count(*) from salesorder");
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
	public Order loadById(int id) {
		Connection conn = DB.getConn();
		String sql = "select o.id,o.addr,o.odate,o.status,"
						  + "u.id,u.username,u.password,u.phone,u.addr,u.rdate, "
						  + "si.id,si.productID,si.unitprice,si.pcount,si.orderid, "
						  + "p.id,p.name,p.descr,p.normalprice,p.memberprice,p.pdate,p.categoryid "
						  + "from salesorder o join user u on(o.userid=u.id) "
						  + "join salesitem si on(o.id=si.orderid) "
						  + "join product p on (si.productid = p.id)"
						  + "where o.id = "+id;
System.out.println(sql);
		Statement stmt = null;
		ResultSet rs = null;
		
		Order o = new Order();
		Cart cart = new Cart();
		CartItem item = new CartItem();
		Product p = new Product();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				User u = new User();
				u.setId(rs.getInt("u.id"));
				u.setUsername(rs.getString("u.username"));
				u.setPassword(rs.getString("u.password"));
				u.setPhone(rs.getString("u.phone"));
				u.setAddr(rs.getString("u.addr"));
				u.setRdate(rs.getTimestamp("u.rdate"));
				
				o.setUser(u);
				o.setId(rs.getInt("o.id"));
				o.setAddr(rs.getString("o.addr"));
				o.setOdate(rs.getTimestamp("o.odate"));
				o.setStatus(rs.getInt("o.status"));
				
				p.setId(rs.getInt("p.id"));
				p.setName(rs.getString("p.name"));
				p.setDescr(rs.getString("p.descr"));
				p.setNormalPrice(rs.getDouble("p.normalprice"));
				p.setMemberPrice(rs.getDouble("p.memberprice"));
				p.setPdate(rs.getTimestamp("p.pdate"));
				p.setCategoryID(rs.getInt("categoryid"));
				
				item.setCount(rs.getInt("si.pcount"));
				item.setPrice(rs.getDouble("si.unitprice"));
				item.setProduct(p);
				
				cart.add(item);
			}
			while(rs.next()) {
				p.setId(rs.getInt("p.id"));
				p.setName(rs.getString("p.name"));
				p.setDescr(rs.getString("p.descr"));
				p.setNormalPrice(rs.getDouble("p.normalprice"));
				p.setMemberPrice(rs.getDouble("p.memberprice"));
				p.setPdate(rs.getTimestamp("p.pdate"));
				p.setCategoryID(rs.getInt("categoryid"));
				
				item.setCount(rs.getInt("si.pcount"));
				item.setPrice(rs.getDouble("si.price"));
				item.setProduct(p);
				
				cart.add(item);
			}
			
			o.setCart(cart);

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		
		return o;
	}
	/*@Override
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
*/

	@Override
	public void updateStatus(int status) {
		Connection conn = DB.getConn();
		String sql = "update salesorder set status="+status;
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
}
