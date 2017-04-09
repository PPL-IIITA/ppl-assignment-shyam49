/**
*Class to store attributes of normal type of girl
*Class extends the girl class
*@author Shyam Kotecha
*/
public class girl_normal extends girl {
	public String type; // To store the type of girl
	girl_normal(String name,int intelligence,int attractiveness,int maintenance,String st,String t,String s,String r) {
		super(name,intelligence,attractiveness,maintenance,st,s,r);
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
