package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Login;

public class DBUtils {
	public static Login findUser(Connection conn,String userName,String password)
	throws SQLException{
		String sql="Select * from ThongTin "
				+ " where ThongTin.UserName = ? and  ThongTin.password= ?";
		
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setString(1,userName);
		pstm.setString(2,password);
		ResultSet rs=pstm.executeQuery();
		if(rs.next()) {
			String password_db= rs.getString("Password");
			String sdt=rs.getString("sdt");
			String address=rs.getString("address");
			Login user= new Login();
			user.setName(userName);
			user.setPassword(password_db);
			user.setAddress(address);
			user.setSDT(sdt);
			return user;
		}
		return null;
	}
	
	public static Login findUserForSignUp(Connection conn, String username)
	throws SQLException{
		String sql="Select * from ThongTin where ThongTin.UserName=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setString(1,username);
		ResultSet rs=pstm.executeQuery();
		if(rs.next()) {
			String name=rs.getString("username");
			String pw=rs.getString("password");
			String gd=rs.getString("gender");
			String type=rs.getString("type");
			String sdt=rs.getString("sdt");
			String address=rs.getString("address");
			Login lg=new Login(name,pw,gd,type,sdt,address);
			return lg;
		}
		return null;
	}
	
	public static void addUser(Connection conn, Login us)
	throws SQLException{
		String sql="Insert ThongTin values(?,?,?,?,?,?)";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setString(1,us.getName());
		pstm.setString(2,us.getPassword());
		pstm.setString(3,us.getGender());
		pstm.setString(4,us.getType());
		pstm.setString(5,us.getSDT());
		pstm.setString(6,us.getAddress());
		pstm.executeUpdate();
	}
	
	/* -- Lấy list tài khoản -- */
	public static List<Login> listUser(Connection conn) throws SQLException {
		String sql = "Select username, password, type from ThongTin";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Login> list = new ArrayList<Login>();
		while (rs.next()) {
			String username = rs.getString("username");
			String type = rs.getString("type");
			String password = rs.getString("password");
			
			Login pr = new Login(username, password, "", type, "", "");
			list.add(pr);
		}
		return list;
	}
	public static void deleteUser(Connection conn, String username)
	throws SQLException{
		String sql="Delete from Cart where username=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setString(1,username);
		pstm.executeUpdate();
	}
}