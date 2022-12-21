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
}
