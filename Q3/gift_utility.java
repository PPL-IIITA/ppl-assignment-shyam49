/**
*Class to store attributes of utility type of gift
*Class extends the gift class
*@author Shyam Kotecha
*/
public class gift_utility extends gift {
	public String type; // To store the type of gift
	gift_utility(String n,int price,int value,String t) {
		super(n,price,value);
		this.type = t;
	}
	/**
	* Function to get the type of gift.
	*/
	public String get_type() {
		return type;
	}
}
