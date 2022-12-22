package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Cart;

public class CartDB {
	public static List<Cart> listCart(Connection conn, String username)
			throws SQLException{
			String sql="Select * from Cart where Cart.username=?";
			PreparedStatement pstm=conn.prepareStatement(sql);
			pstm.setString(1, username);
			ResultSet rs=pstm.executeQuery();
			List<Cart> list=new ArrayList<Cart>();
			while(rs.next()) {
				int id=rs.getInt("idpr");
				String name=rs.getString("tenpr");
				String uname=rs.getString("username");
				int cost=rs.getInt("cost");
				int slpr=rs.getInt("slpr");
				
				Cart pr=new Cart(id,name,slpr,cost,uname);
				list.add(pr);
			}
			return list;
		}
	public static void deleteCart(Connection conn, int idpr, String username) 
			throws SQLException {
        String sql = "Delete from Cart where idpr=? and username=?"; 
        PreparedStatement pstm = conn.prepareStatement(sql); 
        pstm.setInt(1, idpr); 
        pstm.setString(2, username); 
        pstm.executeUpdate();
	}
	
	public static void addCart(Connection conn, Cart crt) 
	throws SQLException{
		String sql="Insert Cart values(?,?,?,?,?)";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1,crt.getIdpr());
		pstm.setString(2,crt.getTenpr());
		pstm.setInt(3,crt.getSlpr());
		pstm.setInt(4,crt.getCost());
		pstm.setString(5,crt.getUsername());
		pstm.executeUpdate();
	}
	
	public static Cart findCart(Connection conn, int idpr, String username)
	throws SQLException{
		String sql="Select * from Cart where idpr=? and username=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1, idpr);
		pstm.setString(2,username);
		ResultSet rs=pstm.executeQuery();
		while(rs.next()) {
			int id=rs.getInt("idpr");
			String name=rs.getString("tenpr");
			String uname=rs.getString("username");
			int cost=rs.getInt("cost");
			int slpr=rs.getInt("slpr");
			
			Cart pr=new Cart(id,name,slpr,cost,uname);
			return pr;
		}
		return null;
	}
	
}
