package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Product;

public class ProductDB {
	public static List<Product> listProduct(Connection conn)
		throws SQLException{
		String sql="Select * from Product";
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
			Product pr=new Product(id,name,type,category,cost,amount,p1,p2,p3,p4);
			list.add(pr);
		}
		return list;
	}
}
