package Project.model;

public class Customer {
	private int custId;
	private String custName;
	private String custPass;
	private int mobNo;
	
	public Customer(int custId, String custName, String custPass, int mobNo) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.mobNo = mobNo;
		this.custPass = custPass;
	}
	
	public Customer(int custId,String custPass) {
		this.custId = custId;
		this.custPass = custPass;
	}

	public int getCustId() {
		return custId;
	}
	public String getCustName() {
		return custName;
	}
	public String getCustPass() {
		return custPass;
	}
	public double getMobNo() {
		return mobNo;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public void setCustPass(String custPass) {
		this.custPass = custPass;
	}
	
	public void setMobNo(int mobNo) {
		this.mobNo = mobNo;
	}
}
