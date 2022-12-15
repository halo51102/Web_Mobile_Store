package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Login;
import bean.Product;

public class ProductDB {
	public static List<Product> listProduct(Connection conn)
		throws SQLException{
		String sql="Select * from Product where category='phone'";
		PreparedStatement pstm=conn.prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		List<Product> list=new ArrayList<Product>();
		while(rs.next()) {
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String type=rs.getString("type");
			String category=rs.getString("category");
			int cost=rs.getInt("cost");
			int amount=rs.getInt("amount");
			String p1=rs.getString("p1");
			String p2=rs.getString("p2");
			String p3=rs.getString("p3");
			String p4=rs.getString("p4");
			String describe=rs.getString("describe");
			Product pr=new Product(id,name,type,category,cost,amount,p1,p2,p3,p4,describe);
			list.add(pr);
		}
		return list;
	}
	public static List<Product> listAccessory(Connection conn)
			throws SQLException{
			String sql="Select * from Product where category='accessory'";
			PreparedStatement pstm=conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			List<Product> list=new ArrayList<Product>();
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String type=rs.getString("type");
				String category=rs.getString("category");
				int cost=rs.getInt("cost");
				int amount=rs.getInt("amount");
				String p1=rs.getString("p1");
				String p2=rs.getString("p2");
				String p3=rs.getString("p3");
				String p4=rs.getString("p4");
				String describe=rs.getString("describe");
				Product pr=new Product(id,name,type,category,cost,amount,p1,p2,p3,p4,describe);
				list.add(pr);
			}
			return list;
		}
	public static Product findProduct(Connection conn,int id)
	throws SQLException{
		String sql="Select * from Product "
				+ " where Product.id = ?";
		
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1,id);
		ResultSet rs=pstm.executeQuery();
		if(rs.next()) {
			int idn=rs.getInt("id");
			String name=rs.getString("name");
			String type=rs.getString("type");
			String category=rs.getString("category");
			int cost=rs.getInt("cost");
			int amount=rs.getInt("amount");
			String p1=rs.getString("p1");
			String p2=rs.getString("p2");
			String p3=rs.getString("p3");
			String p4=rs.getString("p4");
			String describe=rs.getString("describe");
			Product pr=new Product(idn,name,type,category,cost,amount,p1,p2,p3,p4,describe);
			return pr;
		}
		return null;
	}
	public static void addProduct(Connection conn, Product pr) throws SQLException{
		String sql="Insert Product values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1,pr.getId());
		pstm.setString(2,pr.getName());
		pstm.setString(3,pr.getType());
		pstm.setString(4,pr.getCategory());
		pstm.setInt(5,pr.getCost());
		pstm.setInt(6,pr.getAmount());
		pstm.setString(7,pr.getP1());
		pstm.setString(8,pr.getP2());
		pstm.setString(9,pr.getP3());
		pstm.setString(10,pr.getP4());
		pstm.setString(11,pr.getDescribe());
		pstm.executeUpdate();
	}
	public static void editProduct(Connection conn, Product pr) throws SQLException{
		String sql="Update Product set name=?,type=?,cost=?,amount=?,p1=?,p2=?,p3=?,p4=?,describe=? where id=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setString(1,pr.getName());
		pstm.setString(2,pr.getType());
		pstm.setInt(3,pr.getCost());
		pstm.setInt(4,pr.getAmount());
		pstm.setString(5,pr.getP1());
		pstm.setString(6,pr.getP2());
		pstm.setString(7,pr.getP3());
		pstm.setString(8,pr.getP4());
		pstm.setString(9,pr.getDescribe());
		pstm.setInt(10,pr.getId());
		pstm.executeUpdate();
	}
	public static void deleteMonHoc(Connection conn, int id) 
			throws SQLException {
        String sql = "Delete from Product where id=?"; 
        PreparedStatement pstm = conn.prepareStatement(sql); 
        pstm.setInt(1, id);          
        pstm.executeUpdate();
	}
}
