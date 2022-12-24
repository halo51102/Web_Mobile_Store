package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Bill;
import bean.Cart;
import bean.Product;

public class BillDB {
	public static List<Bill> listBill(Connection conn)
			throws SQLException{
			String sql="Select * from Bill";
			PreparedStatement pstm=conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			List<Bill> list=new ArrayList<Bill>();
			while(rs.next()) {
				int id=rs.getInt("idb");
				int idpr=rs.getInt("idpr");
				String tensp=rs.getString("tenpr");
				String uname=rs.getString("username");
				int sumpaid=rs.getInt("sumpaid");
				int slpr=rs.getInt("slpr");
				String date=rs.getString("date");
				String status=rs.getString("status");
				String h=rs.getString("hinh");
				String tenkh=rs.getString("tenkh");
				String sdt=rs.getString("sdt");
				String dc=rs.getString("address");
				Bill pr=new Bill(id, uname, idpr, tensp, slpr, sumpaid,date, status,tenkh,sdt,dc,h);
				list.add(pr);
			}
			return list;
		}
	public static List<Bill> listBillForUser(Connection conn, String username)
			throws SQLException{
			String sql="Select * from Bill where username=?";
			PreparedStatement pstm=conn.prepareStatement(sql);
			pstm.setString(1,username);
			ResultSet rs=pstm.executeQuery();
			List<Bill> list=new ArrayList<Bill>();
			while(rs.next()) {
				int id=rs.getInt("idb");
				int idpr=rs.getInt("idpr");
				String tensp=rs.getString("tenpr");
				String uname=rs.getString("username");
				int slpr=rs.getInt("slpr");
				int sumpaid=rs.getInt("sumpaid");
				String date=rs.getString("date");
				String status=rs.getString("status");
				String tenkh=rs.getString("tenkh");
				String sdt=rs.getString("sdt");
				String dc=rs.getString("address");
				String h=rs.getString("hinh");
				Bill pr=new Bill(id, uname, idpr, tensp, slpr, sumpaid,date, status,tenkh,sdt,dc,h);
				list.add(pr);
			}
			System.out.println("ko lỗi");
			return list;
		}

	public static void addBill(Connection conn, Bill bl) throws SQLException {
		String sql = "Insert Bill values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, bl.getIdb());
		pstm.setString(2, bl.getUsername());
		pstm.setInt(3, bl.getIdpr());
		pstm.setString(4, bl.getTenpr());
		pstm.setInt(5, bl.getSlpr());
		pstm.setInt(6, bl.getSumpaid());
		pstm.setString(7, bl.getDate());
		pstm.setString(8, bl.getStatus());
		pstm.setString(9, bl.getTenkh());
		pstm.setString(10, bl.getSdt());
		pstm.setString(11, bl.getAddress());
		pstm.setString(12,bl.getH1());
		pstm.executeUpdate();
	}

	public static Bill findBill(Connection conn, int idbill) throws SQLException {
		String sql = "Select * from Bill where Bill.idb=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, idbill);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			int idb = rs.getInt("idb");
			String username = rs.getString("username");
			int idpr = rs.getInt("idpr");
			String tenpr = rs.getString("tenpr");
			int slpr = rs.getInt("slpr");
			int sumpaid = rs.getInt("sumpaid");
			String date = rs.getString("date");
			String status = rs.getString("status");
			String tenkh = rs.getString("tenkh");
			String sdt = rs.getString("sdt");
			String address = rs.getString("address");
			String h=rs.getString("hinh");
			Bill b = new Bill(idb, username, idpr, tenpr, slpr, sumpaid, date, status, tenkh, sdt, address,h);
			return b;
		}
		return null;
	}

	public static void updateInfoBill(Connection conn, int idbill, String status, String tenkh, String sdt,
			String address) throws SQLException {
		String sql = "Update Bill set status=?, tenkh=?,sdt=?,address=? where idb=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, status);
		pstm.setString(2, tenkh);
		pstm.setString(3, sdt);
		pstm.setString(4, address);
		pstm.setInt(5, idbill);
		pstm.executeUpdate();
	}
}
