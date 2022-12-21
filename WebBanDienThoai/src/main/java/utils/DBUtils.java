package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Login;

public class DBUtils {
	public static Login findUser(Connection conn,String userName,String password)
	throws SQLException{
		String sql="Select ThongTin.UserName,ThongTin.Password,ThongTin.Gender from ThongTin "
				+ " where ThongTin.UserName = ? and  ThongTin.password= ?";
		
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setString(1,userName);
		pstm.setString(2,password);
		ResultSet rs=pstm.executeQuery();
		if(rs.next()) {
			String password_db= rs.getString("Password");
			Login user= new Login();
			user.setName(userName);
			user.setPassword(password_db);
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
}