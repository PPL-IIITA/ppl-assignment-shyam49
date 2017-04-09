/**
*Class to store attributes of generous type of boy
*Class extends the boy class
*@author Shyam Kotecha
*/
public class boy_generous extends boy {
	public String type; // To store type of the boy
	boy_generous(String name,int intelligence,int attractiveness,int budget,int m,String t,String st) {
		super(name,intelligence,attractiveness,budget,m,st);
		this.type = t;
	}
	/**
	* Function to get the type of boy.
	*/
	public String get_type() {
		return type;
	}
	/**
	* Function to return happiness value of boy in a relationship.
	*/
	public int happy(){
		return 100;
	}
}
