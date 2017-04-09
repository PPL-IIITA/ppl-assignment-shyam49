/**
*Class to store attributes of gift
*@author Shyam Kotecha
*/
public class gift {
	public String g_name; // name of the gifts
	public int price; // price of each gift
	public int value; // value associated with each gift
	/**
	* Constructor to initialize the attributes.
	*/
	gift(String n,int price,int value) {
		this.g_name = n;
		this.price = price;
		this.value= value;
		
	}	
	/**
	*To get name of gift
	*/
	public String get_name() {
		return g_name;
 	}
	/**
	*To get price of gift
	*/
	public int get_price() {
		return price;
	}
	/**
	*To get value of gift
	*/
	public int get_value() {
		return value;
	}
	
}
