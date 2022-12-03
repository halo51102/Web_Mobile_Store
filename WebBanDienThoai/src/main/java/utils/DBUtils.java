package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.LoginBean;

public class DBUtils {
	public static LoginBean findUser(Connection conn,String userName,String password)
	throws SQLException{
		String sql="Select ThongTin.UserName,ThongTin.Password from ThongTin "
				+ " where ThongTin.UserName = ? and  ThongTin.password= ?";
		
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setString(1,userName);
		pstm.setString(2,password);
		ResultSet rs=pstm.executeQuery();
		
		if(rs.next()) {
			String password_db= rs.getString("Password");
			
			LoginBean user= new LoginBean();
			user.setName(userName);
			user.setPassword(password_db);
			return user;
		}
		return null;
	}
}
