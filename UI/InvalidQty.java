package Project.UI;

public class InvalidQty extends Exception{
	public String toString() {
		return "Quantity should be greater than 0!!\n";
	}
}
