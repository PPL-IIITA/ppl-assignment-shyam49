import java.util.*;
import java.io.*;
/**
*Class containing attributes of a couple.
*@author Shyam Kotecha
*/
public class couples{
	public String gf_name; // Girlfriend name.
	public String bf_name; // Boyfriend name.
	public int id; // Couple id.
	public String bf_type; // Boyfriend type.
	public String gf_type; // Girlfriend type.
	public int g_intelligence; // Girlfriend intelligence value.
	public int b_intelligence; // Boyfriend intelligence value.
	public int g_attract; // Girlfriend attractiveness value.
	public int b_attract; // Boyfriend attractiveness value.
	public int g_maintenance; // Girlfriend maintenance cost.
	public int b_budget; // Boyfriend budget.
	public int happiness_value; // Happiness value of couple.
	public int compatibility_value; // Compatibility value of couple.
	ArrayList<gift> gifts_given = new ArrayList<>(); // List of gifts given by boy to girl.
	/**
	*Constructor to initialize attributes of the couple.
	*/
	couples(String gf,String bf,int id,int m,int b,String gf_type,String bf_type,int gi,int bi,int ga,int ba) {
		this.gf_name = gf;
		this.b_intelligence = bi;
		this.b_attract = ba;
		this.g_attract = ga;
		this.g_intelligence = gi;
		this.bf_type = bf_type;
		this.gf_type = gf_type;
		this.bf_name = bf;
		this.id = id;
		this.g_maintenance = m;
		this.b_budget = b;
	}
	/**
	*To set happiness value of couple.
	*/
	public void set_happy(int h) {
		happiness_value = h;
	}
	/**
	*To set compatibility value of couple.
	*/
	public void set_compat(int c) {
		compatibility_value = c;
	}
	/**
	*To add gift to the list of gifts given to the girl.
	*/
	public void add_gift(gift g) {
		gifts_given.add(g);
	}
	/**
	*To get intelligence value of girl.
	*/
	public int get_gintelligence() {
		return g_intelligence;
	}
	/**
	*To get intelligence value of boy.
	*/
	public int get_bintelligence() {
		return b_intelligence;
	}
	/**
	*To get attractiveness value of boy.
	*/
	public int get_batt() {
		return b_attract;
	}
	/**
	*To get attractiveness value of girl.
	*/
	public int get_gatt() {
		return g_attract;
	}
	/**
	*To get name of girl friend.
	*/
	public String get_gf() {
		return gf_name;
	}
	/**
	*To get name of boy friend.
	*/
	public String get_bf() {
		return bf_name;
	}
	/**
	*To get id of the couple.
	*/
	public int get_id() {
		return id;
	}
	/**
	*To get maintenance value of girl.
	*/
	public int get_main() {
		return g_maintenance;
	}
	/**
	*To get budget of boy.
	*/
	public int get_budget() {
		return b_budget;
	}
	/**
	*To get happiness value of couple.
	*/
	public int get_happy() {
		return happiness_value;
	}
	/**
	*To get compatibility value of couple.
	*/
	public int get_compat() {
		return compatibility_value;
	}
}
