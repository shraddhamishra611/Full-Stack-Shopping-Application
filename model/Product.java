package Project.model;

public class Product {

	private int prodId;
	private String prodName;
	private double prodPrice;
	private int prodQty;
	
	public Product() {
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodQty = prodQty;
	}
	
	public Product(int prodId, String prodName, double prodPrice, int prodQty) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodQty = prodQty;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}
	
	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}	
	public int getProdId() {
		return prodId;
	}
	
	public String getProdName() {
		return prodName;
	}
	
	public double getProdPrice() {
		return prodPrice;
	}
	
	public int getProdQty() {
		return prodQty;
	}
	
}
