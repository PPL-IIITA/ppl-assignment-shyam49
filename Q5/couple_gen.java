import java.util.*;
import java.io.*;
import java.sql.Timestamp;
import java.lang.*;
/**
* Class that implements the Comparator class, used to sort gifts in increasing order of their price.
*/
class fun implements Comparator<gift> {
	public int compare(gift g1,gift g2) {
		return g1.price - g2.price;
	}
}
/**
* Class that implements the Comparator class, used to sort couples in decreasing value of their happiness value.
*/
class comp_happy implements Comparator<couples> {
	public int compare(couples c1,couples c2) {
		return c2.happiness_value - c1.happiness_value;
	}
}
/**
* Class that implements the Comparator class, used to sort couples in decreasing order of their compatibility value.
*/
class comp_compat implements Comparator<couples> {
	public int compare(couples c1,couples c2) {
		return c2.compatibility_value - c1.compatibility_value;
	}
}
/**
* Class that implements the Comparator class, used to sort girls in increasing order of their maintenance.
*/
class girl_maint implements Comparator<girl> {
	public int compare(girl g1,girl g2) {
		return g1.get_maintenance() - g2.get_maintenance();
	}
	
}
/**
* Class that implements the Comparator class, used to sort girls in decreasing order of their attractiveness.
*/
class g_att implements Comparator<girl> {
	public int compare(girl g1,girl g2){
		return g2.get_attractiveness() - g1.get_attractiveness();
	}
}
/**
* Class that implements the Comparator class, used to sort boys in decreasing order of their attractiveness.
*/
class boy_att implements Comparator<boy> {
	public int compare(boy b1,boy b2) {
		return b2.get_attractiveness() - b1.get_attractiveness();
	}
}
/**
*Class to make couples & distribute the gifts among them & calculate happiness & compatibility values.
*@author Shyam Kotecha
*/
public class couple_gen {
	read_file ob = new read_file(); // Object of type read_file.
	aux obj = new aux(); // Object of type aux.
	/**
	*To generate couples.
	* @exception IOException On input error.
	* @see IOException
	*/
	public void couple_generator() throws IOException{

		int i,j,z; // Loop variables.
		File f = new File("couples.txt"); // Object of type File to open the file.
        	Boolean b = f.createNewFile(); // Object of type Boolean to create new file.
        	FileWriter f_w; // Object of type FileWriter.
        	BufferedWriter r_w; // Object of type BufferedWriter.
       		f_w = new FileWriter("couples.txt"); 
        	r_w = new BufferedWriter(f_w);
		couples c; // Object of type couples.
		ob.read_boys();
		ob.read_girls();
		
		Arrays.sort(ob.Girls,new girl_maint());
		Arrays.sort(ob.Boys,new boy_att());
		Timestamp t_s = new Timestamp(System.currentTimeMillis());
		
		int id; // Auxiliary variable.
		z = 1;
		id=0;
		r_w.write("\nCouples formed:\n");
		r_w.newLine();
		System.out.println("\nCouples formed:\n");
		int turn=0;
		int g_i,b_i;
		g_i=0;b_i=0;
		while(true){
			int jo=0;
			for(i=0;i<10;i++){
				if(ob.Girls[i].get_st().equals("Single")){
					jo++;
					break;
				}
			}
			if(jo==0){
				break;
			}
			if(turn==0){
				if(ob.Girls[g_i].get_st().equals("Single")){
					for(j=0;j<40;j++){
					       if(ob.Boys[j].get_st().equals("Single") && (ob.Boys[j].get_budget() >= ob.Girls[g_i].get_maintenance())){
							t_s = new Timestamp(System.currentTimeMillis());
					r_w.write(t_s+" "+ob.Boys[j].getname()+" is in a relationship with "+ob.Girls[g_i].getname());
					r_w.newLine();
					System.out.println(t_s+" "+ob.Boys[j].getname()+" is in a relationship with "+ob.Girls[g_i].getname());
					ob.Boys[j].set_st("Committed");
					ob.Girls[g_i].set_st("Committed");
					ob.Girls[g_i].set_bf_name(ob.Boys[j].getname());
					c = new couples(ob.Girls[g_i].getname(),ob.Boys[j].getname(),z,ob.Girls[g_i].get_maintenance(),ob.Boys[j].get_budget(),ob.Girls[g_i].type,ob.Boys[j].type,ob.Girls[g_i].get_intelligence(),ob.Boys[j].get_intelligence(),ob.Girls[g_i].get_attractiveness(),ob.Boys[j].get_attractiveness());
					obj.Couple.add(c);
					z++;
						break;
						}
					}
					if(ob.Girls[g_i].get_st().equals("Committed"))
					turn=1;
					g_i++;
					System.out.println("girl chooses");
				}
				else{
					g_i++;
				}
			}
			else{
				int mm=-100;
				int m_i=-1;
				if(b_i>40){
					turn=0;
				}
				if(ob.Boys[b_i].get_st().equals("Single")){
					for(i=0;i<10;i++){
						if(ob.Girls[i].get_st().equals("Single")&&mm < ob.Girls[i].get_attractiveness() && (ob.Boys[b_i].get_budget() >= ob.Girls[g_i].get_maintenance())) {
							mm = ob.Girls[i].get_attractiveness();
							m_i = i;
						}
					}
					if(mm!=-100){
						t_s = new Timestamp(System.currentTimeMillis());
					r_w.write(t_s+" "+ob.Boys[b_i].getname()+" is in a relationship with "+ob.Girls[m_i].getname());
					r_w.newLine();
					System.out.println(t_s+" "+ob.Boys[b_i].getname()+" is in a relationship with "+ob.Girls[m_i].getname());
					ob.Boys[b_i].set_st("Committed");
					ob.Girls[m_i].set_st("Committed");
					ob.Girls[m_i].set_bf_name(ob.Boys[b_i].getname());
					c = new couples(ob.Girls[m_i].getname(),ob.Boys[b_i].getname(),z,ob.Girls[m_i].get_maintenance(),ob.Boys[b_i].get_budget(),ob.Girls[m_i].type,ob.Boys[b_i].type,ob.Girls[m_i].get_intelligence(),ob.Boys[b_i].get_intelligence(),ob.Girls[m_i].get_attractiveness(),ob.Boys[b_i].get_attractiveness());
					obj.Couple.add(c);
					System.out.println("boy chooses");
					z++;
					}
					
					if(ob.Boys[b_i].get_st().equals("Committed"))
					turn =0;
					b_i++;
				}
				else{
					b_i++;
				}
			}	
		}
		
		obj.num = obj.Couple.size();
		r_w.close();
		f_w.close();
			
	}
	
	/**
	*To distribute gifts among couples.
	* @exception IOException On input error.
	* @see IOException
	*/
	void give_gift() throws IOException{
		
		File f = new File("gifts.txt"); // Object of type File to open the file.
        	Boolean b = f.createNewFile(); // Object of type Boolean to create new file.
        	FileWriter f_w; // Object of type FileWriter.
        	BufferedWriter r_w; // Object of type BufferedWriter.
       		f_w = new FileWriter("gifts.txt");
        	r_w = new BufferedWriter(f_w);
		ob.read_gifts();
		Timestamp t_s = new Timestamp(System.currentTimeMillis());
		Collections.sort(ob.Gifts,new fun());
		int i,j; // Loop variables.
		r_w.write("\n\n\nGift Distribution :\n");
		r_w.newLine();
		System.out.println("\n\n\nGift Distribution :\n");	
		for(i=0;i<obj.num;i++) {
			if(obj.Couple.get(i).bf_type.equals("Miser")) {
				int tot=0;
				j=0;
				while(j!=ob.Gifts.size() && tot < obj.Couple.get(i).g_maintenance) {
					tot += ob.Gifts.get(j).price;
					t_s = new Timestamp(System.currentTimeMillis());
					r_w.write(t_s+" "+obj.Couple.get(i).bf_name+" gives "+ob.Gifts.get(j).g_name+" to "+obj.Couple.get(i).gf_name);
					r_w.newLine();
					System.out.println(t_s+" "+obj.Couple.get(i).bf_name+" gives "+ob.Gifts.get(j).g_name+" to "+obj.Couple.get(i).gf_name);
					obj.Couple.get(i).add_gift(ob.Gifts.get(j));
					j++;
				}		
			}
			
			else if(obj.Couple.get(i).bf_type.equals("Generous")) {
				int tot=0;
				j=ob.Gifts.size() - 1;
				while(j!= -1 && tot < obj.Couple.get(i).b_budget && ob.Gifts.get(j).price <= obj.Couple.get(i).b_budget) {
					tot += ob.Gifts.get(j).price;
					t_s = new Timestamp(System.currentTimeMillis());
					r_w.write(t_s+" "+obj.Couple.get(i).bf_name+" gives "+ob.Gifts.get(j).g_name+" to "+obj.Couple.get(i).gf_name);
					r_w.newLine();
					System.out.println(t_s+" "+obj.Couple.get(i).bf_name+" gives "+ob.Gifts.get(j).g_name+" to "+obj.Couple.get(i).gf_name);
					obj.Couple.get(i).add_gift(ob.Gifts.get(j));
					j--;
				}
			}
			
			else {
				int tot=0;
				j=0;
				int arr[] = new int[ob.Gifts.size()];
				for(j=0;j<ob.Gifts.size();j++){
					arr[j]=0;
				}
				j=0;
				while(j!=ob.Gifts.size() && tot < obj.Couple.get(i).g_maintenance) {
					tot += ob.Gifts.get(j).price;
					t_s = new Timestamp(System.currentTimeMillis());
					r_w.write(t_s+" "+obj.Couple.get(i).bf_name+" gives "+ob.Gifts.get(j).g_name+" to "+obj.Couple.get(i).gf_name);
					r_w.newLine();
					System.out.println(t_s+" "+obj.Couple.get(i).bf_name+" gives "+ob.Gifts.get(j).g_name+" to "+obj.Couple.get(i).gf_name);
					obj.Couple.get(i).add_gift(ob.Gifts.get(j));
					arr[j]=1;
					j++;
				}
				int remain = obj.Couple.get(i).b_budget - tot;
				for(j=0;j<ob.Gifts.size();j++) {
					if(arr[j]==0 && ob.Gifts.get(j).type.equals("Luxury") && remain >= ob.Gifts.get(j).price) {
						t_s = new Timestamp(System.currentTimeMillis());
						r_w.write(t_s+" "+obj.Couple.get(i).bf_name+" gives "+ob.Gifts.get(j).g_name+" to "+obj.Couple.get(i).gf_name);
					r_w.newLine();
						System.out.println(t_s+" "+obj.Couple.get(i).bf_name+" gives "+ob.Gifts.get(j).g_name+" to "+obj.Couple.get(i).gf_name);
						obj.Couple.get(i).add_gift(ob.Gifts.get(j));
						break;
					}
				}
			}
		}
		r_w.close();
		f_w.close();
	}

	/**
	*To calculate happiness & compatibility of couples.
	* @exception IOException On input error.
	* @see IOException
	*/
	public void happiness() throws IOException {
		int i,j; // Loop variables.
		int happy; // Happiness value.
		
		for(i=0;i<obj.num;i++) {
			happy=0;
			int maintenance = obj.Couple.get(i).get_main();
			long tot_val,tot_price;
			tot_val=0;
			tot_price=0;
			for(j=0;j<obj.Couple.get(i).gifts_given.size();j++) {
				tot_price += obj.Couple.get(i).gifts_given.get(j).get_price();
				tot_val += obj.Couple.get(i).gifts_given.get(j).get_value();
			}
			if(obj.Couple.get(i).gf_type.equals("Choosy")) {
				tot_price -= maintenance;
				tot_price = Math.abs(tot_price);
				tot_price += tot_val;
				for(j=0;j<obj.Couple.get(i).gifts_given.size();j++) {
					if(obj.Couple.get(i).gifts_given.get(j).get_type().equals("Luxury")) {
						tot_price += obj.Couple.get(i).gifts_given.get(j).get_value();
					}
				}
				happy += (int)Math.log10((double)tot_price);
			}
			
			else if(obj.Couple.get(i).gf_type.equals("Normal")) {
				tot_price += tot_val;
				tot_price -= maintenance;
				tot_price = Math.abs(tot_price);
				happy += tot_price;
			}
			
			else {
				tot_price -= maintenance;
				tot_price = Math.abs(tot_price);
				happy += (int)Math.exp((double)tot_price);
			}
	
			if(obj.Couple.get(i).bf_type.equals("Miser")) {
				happy += Math.abs(obj.Couple.get(i).get_budget() - tot_price);

			}	
			
			else if(obj.Couple.get(i).bf_type.equals("Generous")) {
				happy += happy;
			}
			
			else {
				happy += obj.Couple.get(i).get_gintelligence();
			}
			if(happy<0){
				happy=0;
			}
			obj.Couple.get(i).set_happy(happy);
			int comp=0;
			comp = Math.abs(obj.Couple.get(i).get_budget()-obj.Couple.get(i).get_main()) + Math.abs(obj.Couple.get(i).get_gatt()-obj.Couple.get(i).get_batt()) + Math.abs(obj.Couple.get(i).get_bintelligence() - obj.Couple.get(i).get_gintelligence());
			obj.Couple.get(i).set_compat(comp);
			
		}
	}
		
	/**
	*To print output to screen and write it to file.
	* @exception IOException On input error.
	* @see IOException
	*/
	public void print() throws IOException {
		int k; // Value of k used to generate output.
		File f = new File("op5_happy.txt"); // Object of type File to open the file.
        	Boolean b = f.createNewFile(); // Object of type Boolean to create new file.
        	FileWriter f_w; // Object of type FileWriter.
        	BufferedWriter r_w; // Object of type BufferedWriter.
       		f_w = new FileWriter("op5_happy.txt");
        	r_w = new BufferedWriter(f_w);
		k=5;
		r_w.write("\n\n\nHappiness:\n");
		r_w.newLine();
		System.out.println("\n\n\nHappiness:\n");
		Collections.sort(obj.Couple,new comp_happy());
		r_w.write("\n\nSorting on the basis of happiness value\n");
		r_w.newLine();
		System.out.println("\n\nSorting on the basis of happiness value\n");
		for(int i=0;i<obj.Couple.size();i++) {
			r_w.write(obj.Couple.get(i).get_bf()+" "+obj.Couple.get(i).get_gf()+" happiness value = "+obj.Couple.get(i).get_happy());
			r_w.newLine();
			System.out.println(obj.Couple.get(i).get_bf()+" "+obj.Couple.get(i).get_gf()+" happiness value = "+obj.Couple.get(i).get_happy());
		}
		System.out.println("\n\ntop k happy couples\n");
		r_w.write("\n\ntop k happy couples\n");
		if(k>obj.Couple.size()) {
			for(int i=0;i<obj.Couple.size();i++) {
				System.out.println(obj.Couple.get(i).get_bf()+" "+obj.Couple.get(i).get_gf()+" happiness value = "+obj.Couple.get(i).get_happy());
				r_w.write(obj.Couple.get(i).get_bf()+" "+obj.Couple.get(i).get_gf()+" happiness value = "+obj.Couple.get(i).get_happy());
				r_w.newLine();
			}
		}
		else {
			for(int i=0;i<k;i++) {
				System.out.println(obj.Couple.get(i).get_bf()+" "+obj.Couple.get(i).get_gf()+" happiness value = "+obj.Couple.get(i).get_happy());
				r_w.write(obj.Couple.get(i).get_bf()+" "+obj.Couple.get(i).get_gf()+" happiness value = "+obj.Couple.get(i).get_happy());
				r_w.newLine();
			}
		}
		
		r_w.close();
		f_w.close();
	}
	
}
