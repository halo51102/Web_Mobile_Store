package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.oracle.wls.shaded.org.apache.regexp.recompile;

import bean.Product;
import bean.Voucher;

public class VoucherDB {
	public static List<Voucher> listVoucher(Connection conn)
			throws SQLException{
		// Lấy voucher
			String sql="select * from Voucher ";
			PreparedStatement pstm=conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			List<Voucher> list=new ArrayList<Voucher>();
			while(rs.next()) {
				int id =rs.getInt("id");
				String TenVC=rs.getString("TenVC");
				String HDSD=rs.getString("HDSD");
				String ThoiGianBD=rs.getString("ThoiGianBD");
				String ThoiGianKT=rs.getString("ThoiGianKT");
				int TienGiamPT=rs.getInt("TienGiamPT");
				int TienGiamDong=rs.getInt("TienGiamDong");
				String DieuKien=rs.getString("DieuKien");
				int SoLuong=rs.getInt("SoLuong");
				Voucher vc = new Voucher(id, TenVC, HDSD, ThoiGianBD, ThoiGianKT, TienGiamPT, TienGiamDong, DieuKien, SoLuong);
				list.add(vc);
			}
			return list;
		}
	public static Voucher findVoucher(Connection conn,int id)
			throws SQLException{
		// Tìm voucher có id ?
			String sql= "select * from Voucher where id= ? ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1,id);
			ResultSet rs=pstm.executeQuery();
			if(rs.next()) {
				int Id =rs.getInt("id");
				String TenVC =rs.getString("TenVC");
				String HDSD=rs.getString("HDSD");
				String ThoiGianBD=rs.getString("ThoiGianBD");
				String ThoiGianKT=rs.getString("ThoiGianKT");
				int TienGiamPT=rs.getInt("TienGiamPT");
				int TienGiamDong=rs.getInt("TienGiamDong");
				String DieuKien=rs.getString("DieuKien");
				int SoLuong=rs.getInt("SoLuong");
				Voucher vc = new Voucher(Id, TenVC, HDSD, ThoiGianBD, ThoiGianKT, TienGiamPT, TienGiamDong, DieuKien, SoLuong);
				return vc;
			}
			return null;
		}
	public static void addVoucher(Connection conn, Voucher vc) throws SQLException{
		// Thêm voucher mới		
		String sql= "insert into Voucher ([id],[TenVC],[HDSD],[ThoiGianBD], [ThoiGianKT], [TienGiamPT], [TienGiamDong], [DieuKien], [SoLuong]) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1,vc.getId());
		pstm.setString(2,vc.getTenVC());
		pstm.setString(3,vc.getHDSD());
		pstm.setString(4,vc.getThoiGianBD());
		pstm.setString(5,vc.getThoiGianKT());
		pstm.setInt(6,vc.getTienGiamPT());
		pstm.setInt(7,vc.getTienGiamDong());
		pstm.setString(8,vc.getDieuKien());
		pstm.setInt(9,vc.getSoLuong());
		pstm.executeUpdate();
	}

	public static void editVoucher(Connection conn, Voucher vc) throws SQLException{
		// cập nhật lại voucher
		String sql ="update Voucher set TenVC= ?,HDSD=?, ThoiGianBD= ?, ThoiGianKT=?, TienGiamPT=?, TienGiamDong=?, DieuKien=?, SoLuong=?"
				+ " where Voucher.id= ? ";
		PreparedStatement pstm= conn.prepareStatement(sql);
		pstm.setString(1,vc.getTenVC());
		pstm.setString(2,vc.getHDSD());
		pstm.setString(3,vc.getThoiGianBD());
		pstm.setString(4,vc.getThoiGianKT());
		pstm.setInt(5,vc.getTienGiamPT());
		pstm.setInt(6,vc.getTienGiamDong());
		pstm.setString(7,vc.getDieuKien());
		pstm.setInt(8,vc.getSoLuong());
		pstm.setInt(9,vc.getId());
		pstm.executeUpdate();
	}
	public static void deleteVoucher(Connection conn, int id) 
			throws SQLException {
		// Xoa voucher
        String sql = "Delete from Voucher where id=?"; 
        PreparedStatement pstm = conn.prepareStatement(sql); 
        pstm.setInt(1,id);          
        pstm.executeUpdate();
	}
}
