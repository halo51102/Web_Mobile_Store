package bean;

public class Login {
	
	public String name,password;
	public String gender, type, sdt, address;
	public Login() {
	}
	public Login(String n,String pw, String gd, String tp, String s, String adr) {
		name=n;
		password=pw;
		gender=gd;
		type=tp;
		sdt=s;
		address=adr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gen) {
		this.gender=gen;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type=type;
	}
	public String getSDT() {
		return sdt;
	}
	public void setSDT(String s) {
		this.sdt=s;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String add) {
		this.address=add;
	}

}