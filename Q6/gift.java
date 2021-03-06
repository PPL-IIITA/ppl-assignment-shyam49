/**
*Class to store attributes of gift
*@author Shyam Kotecha
*/
public class gift {
	public String g_name; // gift name
	public int price; // price of gift
	public int value; // value of gift
	public String type; // type of gift
	/**
	* Constructor to initialize the attributes.
	*/
	gift(String n,int price,int value,String type) {
		this.g_name = n;
		this.price = price;
		this.value= value;
		this.type = type;
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
	/**
	*To get type of gift
	*/
	public String get_type() {
		return type;
	}
}
