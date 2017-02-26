/**
*Class to store attributes of boy
*@author Shyam Kotecha
*/
public class boy {

	public String name;
	public int intelligence;
	public int budget;
	public int attractiveness;
	public int min_att_req;
	public String status;
	public String type;
	/**
	* Constructor to initialize the attributes.
	*/
	boy(String name,int intelligence,int attractiveness,int budget,int m,String t,String st) {
		this.name = name;
		this.intelligence = intelligence;
		this.attractiveness = attractiveness;
		this.budget = budget;
		this.min_att_req = m;
		this.type = t;
		this.status = st;
	}	
	/**
	* To set status of boy
	*/
	public void set_st(String s) {
		status = s;
	}
	/**
	* To set type of boy
	*/
	public void set_type(String t) {
		type=t;
	}	
	/**
	* To get the name of boy
	*/
	public String get_type() {
		return type;
	}
	/**
	* To get the name of boy
	*/
	public String getname() {
		return name;
	}
	/**
	* To get intelligence of boy
	*/
	public int get_intelligence() {
		return intelligence;
	}
	/**
	* To get budget of boy
	*/
	public int get_budget() {
		return budget;
	}
	/**
	* To get attractiveness of boy
	*/
	public int get_attractiveness() {
		return attractiveness;
	}
	/**
	* To get minimum attractiveness of girl required by the boy
	*/
	public int get_min() {
		return min_att_req;
	}
	/**
	* To get status of boy
	*/
	public String get_st() {
		return status;
	}
}
