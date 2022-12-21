package bean;

public class Cart {
	public String tenpr, username;
	public int idpr , slpr, cost;
	
	public Cart() {
		
	}
	
	public Cart(int id, String ten, int sl, int cos, String uname) {
		idpr=id;
		tenpr=ten;
		slpr=sl;
		cost=cos;
		username=uname;
	}
	
	public String getTenpr() {
		return tenpr;
	}

	public void setTenpr(String tenpr) {
		this.tenpr = tenpr;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getIdpr() {
		return idpr;
	}

	public void setIdpr(int idpr) {
		this.idpr = idpr;
	}

	public int getSlpr() {
		return slpr;
	}

	public void setSlpr(int slpr) {
		this.slpr = slpr;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
