/**
*Class to store attributes of girl
*@author Shyam Kotecha
*/
public class girl {

	public String name;
	public int intelligence;
	public int maintenance;
	public int attractiveness;
	public String boy_frnd_name;
	public String status;
	/**
	* Constructor to initialize the attributes.
	*/
	girl(String name,int intelligence,int attractiveness,int maintenance,String st,String s) {
		this.name = name;
		this.intelligence = intelligence;
		this.attractiveness = attractiveness;
		this.status = st;
		this.maintenance = maintenance;
		this.boy_frnd_name = s;
	}
	/**
	* To get status of girl
	*/
	public String get_st() {
		return status;
	}
	/**
	* To set status of girl
	*/
	public void set_st(String s) {
		status = s;
	}
	/**
	* To set boy friend name of girl
	*/
	public void set_bf_name(String s) {
		boy_frnd_name = s;
	}
	/**
	* To get name of girl
	*/
	public String getname() {
		return name;
	}
	/**
	* To get intelligence of girl
	*/
	public int get_intelligence() {
		return intelligence;
	}
	/**
	* To get maintenance of girl
	*/
	public int get_maintenance() {
		return maintenance;
	}
	/**
	* To get attractiveness of girl
	*/
	public int get_attractiveness() {
		return attractiveness;
	}
	/**
	* To get boy friend name of girl
	*/
	public String get_bf() {
		return boy_frnd_name;
	}	
}
