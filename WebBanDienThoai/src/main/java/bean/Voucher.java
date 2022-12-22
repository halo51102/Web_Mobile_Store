package bean;

import java.sql.Date;

public class Voucher {
	
	public int id;
	public String HDSD;
	public String TenVC;
	public String ThoiGianBD;
	public String ThoiGianKT;
	public int TienGiamPT;
	public int TienGiamDong;
	public String DieuKien;
	public int SoLuong;
	
	public Voucher() {
		// TODO Auto-generated constructor stub
	}
	
	public Voucher(int Id, String tenVC, String hDSD, String thoiGianBD,
			String thoiGianKT, int tienGiamPT, int tienGiamDong, String dieuKien, int soLuong) {
		super();
		this.id = Id;
		this.TenVC = tenVC;
		this.HDSD = hDSD;
		this.ThoiGianBD = thoiGianBD;
		this.ThoiGianKT = thoiGianKT;
		this.TienGiamPT = tienGiamPT;
		this.TienGiamDong = tienGiamDong;
		this.DieuKien = dieuKien;
		this.SoLuong = soLuong;
	}

	public int getId() {
		return id;
	}

	public void setId(int Id) {
		this.id = Id;
	}

	public String getHDSD() {
		return HDSD;
	}

	public void setHDSD(String hDSD) {
		this.HDSD = hDSD;
	}


	public String getTenVC() {
		return TenVC;
	}

	public void setTenVC(String tenVC) {
		this.TenVC = tenVC;
	}

	public String getThoiGianBD() {
		return ThoiGianBD;
	}

	public void setThoiGianBD(String thoiGianBD) {
		this.ThoiGianBD = thoiGianBD;
	}

	public String getThoiGianKT() {
		return ThoiGianKT;
	}

	public void setThoiGianKT(String thoiGianKT) {
		this.ThoiGianKT = thoiGianKT;
	}

	public int getTienGiamPT() {
		return TienGiamPT;
	}

	public void setTienGiamPT(int tienGiamPT) {
		this.TienGiamPT = tienGiamPT;
	}

	public int getTienGiamDong() {
		return TienGiamDong;
	}

	public void setTienGiamDong(int tienGiamDong) {
		this.TienGiamDong = tienGiamDong;
	}

	public String getDieuKien() {
		return DieuKien;
	}

	public void setDieuKien(String dieuKien) {
		this.DieuKien = dieuKien;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		this.SoLuong = soLuong;
	}
	
	
	
	
	

}
