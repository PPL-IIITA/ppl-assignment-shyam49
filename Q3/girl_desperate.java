/**
*Class to store attributes of desperate type of girl
*Class extends the girl class
*@author Shyam Kotecha
*/
public class girl_desperate extends girl {
	public String type; // To store the type of girl
	girl_desperate(String name,int intelligence,int attractiveness,int maintenance,String st,String t,String s) {
		super(name,intelligence,attractiveness,maintenance,st,s);
		this.type = t;
	}
	/**
	* Function to get the type of girl.
	*/
	public String get_type() {
		return type;
	}
	/**
	* Function to return happiness value of girl in a relationship.
	*/
	public int happy(){
		return 100;
	}
}
