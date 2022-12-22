package bean;

public class Bill {
	public int idb,sumpaid,slpr,idpr;
	public String username, tenpr,date,status;
	public String tenkh,sdt,address;
	
	public Bill() {
		
	}
	public Bill(int bill, String uname, int idsp, String tensp, int slsp, int tong,String ngay, String tt, String tenkh, String sdt, String address) {
		idb=bill;
		username=uname;
		idpr=idsp;
		tenpr=tensp;
		slpr=slsp;
		sumpaid=tong;
		date=ngay;
		status=tt;
		this.tenkh=tenkh;
		this.sdt=sdt;
		this.address=address;
	}
	public int getIdb() {
		return idb;
	}
	public void setIdb(int idb) {
		this.idb = idb;
	}
	public int getSumpaid() {
		return sumpaid;
	}
	public void setSumpaid(int sumpaid) {
		this.sumpaid = sumpaid;
	}
	public int getSlpr() {
		return slpr;
	}
	public void setSlpr(int slpr) {
		this.slpr = slpr;
	}
	public int getIdpr() {
		return idpr;
	}
	public void setIdpr(int idpr) {
		this.idpr = idpr;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTenpr() {
		return tenpr;
	}
	public void setTenpr(String tenpr) {
		this.tenpr = tenpr;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
