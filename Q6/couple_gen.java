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

		File f = new File("couples.txt"); // Object of type File to open the file.
        	Boolean b = f.createNewFile(); // Object of type Boolean to create new file.
        	FileWriter f_w; // Object of type FileWriter.
        	BufferedWriter r_w; // Object of type BufferedWriter.
       		f_w = new FileWriter("couples.txt"); 
        	r_w = new BufferedWriter(f_w);
		couples c; // Object of type couples.
		ob.read_boys();
		ob.read_girls();
		Timestamp t_s = new Timestamp(System.currentTimeMillis());
		int i,j,z; // Loop variables.
		int id;
		z = 1;
		id=0;
		r_w.write("\nCouples formed:\n");
		r_w.newLine();
		System.out.println("\nCouples formed:\n");
		int t=30;
		for(int d=0;d<t;d++){
			r_w.write("Day "+String.valueOf(d+1)+":\nCouples are:\n");
			System.out.println("Day "+ String.valueOf(d+1) +":\nCouples are:\n");
			for(i=0;i<10;i++){
				if(ob.Girls[i].get_st().equals("Single")){
					for(j=0;j<60;j++){
						if(ob.Boys[j].get_st().equals("Single") && (ob.Boys[j].get_budget() >= ob.Girls[i].get_maintenance()) && (ob.Girls[i].get_attractiveness() >= ob.Boys[j].get_min())) {
							
							ob.Boys[j].set_st("Committed");
							ob.Girls[i].set_st("Committed");
							ob.Girls[i].set_bf_name(ob.Boys[j].getname());
							c = new couples(ob.Girls[i].getname(),ob.Boys[j].getname(),z,ob.Girls[i].get_maintenance(),ob.Boys[j].get_budget(),ob.Girls[i].type,ob.Boys[j].type,ob.Girls[i].get_intelligence(),ob.Boys[j].get_intelligence(),ob.Girls[i].get_attractiveness(),ob.Boys[j].get_attractiveness());
							obj.Couple.add(c);
							z++;
							break;	
						}
					}	
				}	
			}
			
			give_gift();
			happiness();
			for(int y=0;y<obj.Couple.size();y++){
				if(obj.Couple.get(y).get_happy() < t || obj.Couple.get(y).bf_name.equals("Single") || obj.Couple.get(y).gf_name.equals("Single")){
					continue;
				}
				
				t_s = new Timestamp(System.currentTimeMillis());
				r_w.write(t_s+" "+obj.Couple.get(y).get_bf()+" is in a relationship with "+obj.Couple.get(y).get_gf());
				r_w.newLine();
				System.out.println(t_s+" "+obj.Couple.get(y).get_bf()+" is in a relationship with "+obj.Couple.get(y).get_gf());
			}
			System.out.println("\n\n");
			r_w.write("\n\n");
			int n=obj.Couple.size();
			for(int y=0;y<n;y++){
				if(obj.Couple.get(y).get_happy() < t){
					for(int gg=0;gg<10;gg++){
						if(obj.Couple.get(y).get_gf().equals(ob.Girls[gg].getname())){
							ob.Girls[gg].set_st("Single");
							break;
						}
					}
					for(int bb=0;bb<60;bb++){
						if(obj.Couple.get(y).get_bf().equals(ob.Boys[bb].getname())){
							ob.Boys[bb].set_st("Single");
							break;
						}
					}
					obj.Couple.get(y).bf_name = "Single";
					obj.Couple.get(y).gf_name = "Single";
				}
			}
		}	
		
		
		r_w.close();
		f_w.close();
			
	}
	
	/**
	*To distribute gifts among couples.
	* @exception IOException On input error.
	* @see IOException
	*/
	void give_gift() throws IOException{
		
		
		ob.read_gifts();
		Timestamp t_s = new Timestamp(System.currentTimeMillis());
		Collections.sort(ob.Gifts,new fun());
		int i,j; // Loop variables.
		int n=obj.Couple.size(); // Size of couple array.
		for(i=0;i<n;i++) {
			if(obj.Couple.get(i).bf_name.equals("Single")){
				continue;
			}
			if(obj.Couple.get(i).bf_type.equals("Miser")) {
				int tot=0;
				j=0;
				while(j!=ob.Gifts.size() && tot < obj.Couple.get(i).g_maintenance) {
					tot += ob.Gifts.get(j).price;
					
					obj.Couple.get(i).add_gift(ob.Gifts.get(j));
					j++;
				}		
			}
			
			else if(obj.Couple.get(i).bf_type.equals("Generous")) {
				int tot=0;
				j=ob.Gifts.size() - 1;
				while(j!= -1 && tot < obj.Couple.get(i).b_budget && (tot+ob.Gifts.get(j).price) <= obj.Couple.get(i).b_budget) {
					tot += ob.Gifts.get(j).price;
					
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
					
					obj.Couple.get(i).add_gift(ob.Gifts.get(j));
					arr[j]=1;
					j++;
				}
				int remain = obj.Couple.get(i).b_budget - tot;
				for(j=0;j<ob.Gifts.size();j++) {
					if(arr[j]==0 && ob.Gifts.get(j).type.equals("Luxury") && remain >= ob.Gifts.get(j).price) {
						t_s = new Timestamp(System.currentTimeMillis());
						tot += ob.Gifts.get(j).price;
						obj.Couple.get(i).add_gift(ob.Gifts.get(j));
						break;
					}
				}
			}
		}
		
	}

	/**
	*To calculate happiness & compatibility of couples.
	* @exception IOException On input error.
	* @see IOException
	*/
	public void happiness() throws IOException {
		int i,j; // Loop variables.
		int happy; // Happiness value.
		int n=obj.Couple.size(); // Size of couple array.
		for(i=0;i<n;i++) {
			if(obj.Couple.get(i).bf_name.equals("Single")){
				continue;
			}
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
				
				tot_price += tot_val;
				for(j=0;j<obj.Couple.get(i).gifts_given.size();j++) {
					if(obj.Couple.get(i).gifts_given.get(j).get_type().equals("Luxury")) {
						tot_price += obj.Couple.get(i).gifts_given.get(j).get_value();
					}
				}
				if(tot_price > 0)
				happy += (long)Math.log10((double)tot_price);
				else{
					happy=0;
				}
			}
			
			else if(obj.Couple.get(i).gf_type.equals("Normal")) {
				tot_price += tot_val;
				tot_price -= maintenance;
				if(tot_price < 0)
				tot_price=0;
				happy += tot_price;
			}
			
			else {
				tot_price -= maintenance;
				
				if(tot_price<0)
				tot_price=0;
				happy += (long)Math.exp((double)tot_price);
			}
	
			if(obj.Couple.get(i).bf_type.equals("Miser")) {
				if(obj.Couple.get(i).get_budget() - tot_price >= 0){
					happy+=obj.Couple.get(i).get_budget() - tot_price;
				}
				
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
			
			
		}
		
	}
}
