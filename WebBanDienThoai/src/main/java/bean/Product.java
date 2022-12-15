package bean;

public class Product {
	private int id;
	private String name;
	private String type;
	private String category;
	private int cost;
	private int amount;
	private String p1;
	private String p2;
	private String p3;
	private String p4;
	private String describe;
	
	public Product() {}
	public Product(int id,String name,String type,String category,
			int cost,int amount,String p1, String p2, String p3, String p4, String describe) {
		super();
		this.id=id;
		this.name=name;
		this.type=type;
		this.category=category;
		this.cost=cost;
		this.amount=amount;
		this.p1=p1;
		this.p2=p2;
		this.p3=p3;
		this.p4=p4;
		this.describe=describe;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type=type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category=category;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost=cost;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount=amount;
	}
	public String getP1() {
		return p1;
	}
	public void setP1(String p1) {
		this.p1=p1;
	}
	public String getP2() {
		return p2;
	}
	public void setP2(String p2) {
		this.p2=p2;
	}
	public String getP3() {
		return p3;
	}
	public void setP3(String p3) {
		this.p3=p3;
	}
	public String getP4() {
		return p4;
	}
	public void setP4(String p4) {
		this.p4=p4;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe=describe;
	}
}
