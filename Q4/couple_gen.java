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
		int id,cou,cou2; // Auxiliary variables.
		z = 1;
		id=0;
		r_w.write("\nCouples formed:\n");
		r_w.newLine();
		System.out.println("\nCouples formed:\n");
		String gt,bt;
		gt="";bt="";
		for(i=0;i<10;i++) {
			cou2=0;
			for(j=0;j<ob.gc;j++){
				if((ob.Girlsc[j].getname()).equals(ob.Girls[i].getname())){
					gt = ob.Girlsc[j].get_type();
					cou2++;
					break;
				}
			}
			if(cou2==0){
				for(j=0;j<ob.gd;j++){
				if((ob.Girlsd[j].getname()).equals(ob.Girls[i].getname())){
					gt = ob.Girlsd[j].get_type();
					cou2++;
					break;
				}
			}
			}
			if(cou2==0){
				for(j=0;j<ob.gn;j++){
				if((ob.Girlsn[j].getname()).equals(ob.Girls[i].getname())){
					gt = ob.Girlsn[j].get_type();
					cou2++;
					break;
				}
			}
			}
			for(j=0;j<40;j++) {
				if(ob.Boys[j].get_st().equals("Single") && (ob.Boys[j].get_budget() >= ob.Girls[i].get_maintenance()) && (ob.Girls[i].get_attractiveness() >= ob.Boys[j].get_min())) {
					cou=0;
					t_s = new Timestamp(System.currentTimeMillis());
					r_w.write(t_s+" "+ob.Boys[j].getname()+" is in a relationship with "+ob.Girls[i].getname());
					r_w.newLine();
					System.out.println(t_s+" "+ob.Boys[j].getname()+" is in a relationship with "+ob.Girls[i].getname());
					ob.Boys[j].set_st("Committed");
					ob.Girls[i].set_st("Committed");
					ob.Girls[i].set_bf_name(ob.Boys[j].getname());
					int k;
					if(cou==0){
						for(k=0;k<ob.bm;k++){
						
							
							if((ob.Boysm[k]).equals((ob.Boys[j]).getname())){
								bt=ob.Boysm[k].get_type();
								cou++;
								break;
							}
						}
					}
					if(cou==0){
						for(k=0;k<ob.bge;k++){
							if((ob.Boysge[k].getname()).equals(ob.Boys[j].getname())){
								bt=ob.Boysge[k].get_type();
								cou++;
								break;
							}
						}
					}
					if(cou==0){
						for(k=0;k<ob.bgn;k++){
							if((ob.Boysgn[k].getname()).equals(ob.Boys[j].getname())){
								bt=ob.Boysgn[k].get_type();
								cou++;
								break;
							}
						}
					}
					c = new couples(ob.Girls[i].getname(),ob.Boys[j].getname(),z,ob.Girls[i].get_maintenance(),ob.Boys[j].get_budget(),gt,bt,ob.Girls[i].get_intelligence(),ob.Boys[j].get_intelligence(),ob.Girls[i].get_attractiveness(),ob.Boys[j].get_attractiveness());
					obj.Couple.add(c);
					z++;
					break;
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
				String gt;
				gt="";
				int remain = obj.Couple.get(i).b_budget - tot;
				for(j=0;j<ob.Gifts.size();j++) {
					int h=0;
					for(gift_essential gz : ob.Giftse){
						if(gz.get_name().equals(ob.Gifts.get(j).g_name)){
							gt=gz.get_type();
							h++;
							break;
						}
					}
					if(h==0){
						for(gift_luxury gz : ob.Giftsl){
						if(gz.get_name().equals(ob.Gifts.get(j).g_name)){
							gt=gz.get_type();
							h++;
							break;
						}
					}
					}
					if(h==0){
						for(gift_utility gz : ob.Giftsu){
						if(gz.get_name().equals(ob.Gifts.get(j).g_name)){
							gt=gz.get_type();
							h++;
							break;
						}
					}
					}
					if(arr[j]==0 && gt.equals("Luxury") && remain >= ob.Gifts.get(j).price) {
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
				String gt;
				for(j=0;j<obj.Couple.get(i).gifts_given.size();j++) {
					int f=0;
					gt="";	
					for(gift_essential gz : ob.Giftse){
						if(gz.get_name().equals(obj.Couple.get(i).gifts_given.get(j).g_name)){
							gt=gz.get_type();
							f++;
							break;
						}
					}
					if(f==0){
						for(gift_luxury gz : ob.Giftsl){
						if(gz.get_name().equals(obj.Couple.get(i).gifts_given.get(j).g_name)){
							gt=gz.get_type();
							f++;
							break;
						}
					}
					}
					if(f==0){
						for(gift_utility gz : ob.Giftsu){
						if(gz.get_name().equals(obj.Couple.get(i).gifts_given.get(j).g_name)){
							gt=gz.get_type();
							f++;
							break;
						}
					}
					}
					if(gt.equals("Luxury")) {
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
		File f = new File("op4_happy&comp.txt"); // Object of type File to open the file.
        	Boolean b = f.createNewFile(); // Object of type Boolean to create new file.
        	FileWriter f_w; // Object of type FileWriter.
        	BufferedWriter r_w; // Object of type BufferedWriter.
       		f_w = new FileWriter("op4_happy&comp.txt");
        	r_w = new BufferedWriter(f_w);
		k=5;
		r_w.write("\n\n\nHappiness and compatibility:\n\nvalue of k=5\n\n");
		r_w.newLine();
		System.out.println("\n\n\nHappiness and compatibility:\n\nvalue of k=5\n\n");
		Collections.sort(obj.Couple,new comp_happy());
		r_w.write("\n\nSorting on the basis of compatibility value\n");
		r_w.newLine();
		
		r_w.write("\n\nSorting on the basis of compatibility value\n");
		for(int i=0;i<obj.Couple.size();i++) {
			r_w.write(obj.Couple.get(i).get_bf()+" "+obj.Couple.get(i).get_gf()+" compatibility value = "+obj.Couple.get(i).get_compat());
			r_w.newLine();
			System.out.println(obj.Couple.get(i).get_bf()+" "+obj.Couple.get(i).get_gf()+" compatibility value = "+obj.Couple.get(i).get_compat());
		}
		System.out.println("\n\ntop k compatible couples\n");
		if(k > obj.Couple.size()) {
			for(int i=0;i<obj.Couple.size();i++) {
				System.out.println(obj.Couple.get(i).get_bf()+" "+obj.Couple.get(i).get_gf()+" compatibility value = "+obj.Couple.get(i).get_compat());
				r_w.write(obj.Couple.get(i).get_bf()+" "+obj.Couple.get(i).get_gf()+" compatibility value = "+obj.Couple.get(i).get_happy());
				r_w.newLine();
			}
		}
		else {
			for(int i=0;i<k;i++) {
				System.out.println(obj.Couple.get(i).get_bf()+" "+obj.Couple.get(i).get_gf()+" compatibility value = "+obj.Couple.get(i).get_compat());
				r_w.write(obj.Couple.get(i).get_bf()+" "+obj.Couple.get(i).get_gf()+" compatibility value = "+obj.Couple.get(i).get_happy());
				r_w.newLine();
			}
		}
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
		
		
		
		int job=0; // Auxiliary variable.
		while(job<k){
			System.out.println(obj.Couple.get(obj.Couple.size()-1).get_gf() + " & "+obj.Couple.get(obj.Couple.size()-1).get_bf()+" are breaking up.");
			r_w.write(obj.Couple.get(obj.Couple.size()-1).get_gf() + " & "+obj.Couple.get(obj.Couple.size()-1).get_bf()+" are breaking up.");
			r_w.newLine();
			
			for(int j=0;j<40;j++){
				if(obj.Couple.get(obj.Couple.size()-1).get_bf().equals(ob.Boys[j].getname())){
					ob.Boys[j].status = "Single";
					ob.Boys[j].old = obj.Couple.get(obj.Couple.size()-1).get_gf();
				}
			}
			for(int j=0;j<10;j++){
				if(obj.Couple.get(obj.Couple.size()-1).get_gf().equals(ob.Girls[j].getname())){
					ob.Girls[j].status = "Single";
					ob.Girls[j].r = "y";
				}
			}
			obj.Couple.remove(obj.Couple.size()-1);job++;
		}
		
		r_w.close();
		f_w.close();
		
		File f2 = new File("final_couples.txt"); // Object of type File to open the file.
        	Boolean b2 = f2.createNewFile(); // Object of type Boolean to create new file.
		FileWriter f_w2; // Object of type FileWriter.
        	BufferedWriter r_w2; // Object of type BufferedWriter.
       		f_w2 = new FileWriter("final_couples.txt");
        	r_w2 = new BufferedWriter(f_w2);
		couples c;
		
		Timestamp t_s = new Timestamp(System.currentTimeMillis());
		int i,j,z; // Loop varibles.
		int id,cou,cou2; // Auxiliary variables.
		z = 1;
		id=0;
		r_w2.write("\nCouples finally formed after breakups:\n");
		r_w2.newLine();
		System.out.println("\nCouples finally formed after breakups:\n");
		String gt,bt;
		gt="";bt="";
		for(i=0;i<10;i++) {
			cou2=0;
			for(j=0;j<ob.gc;j++){
				if((ob.Girlsc[j].getname()).equals(ob.Girls[i].getname())){
					gt = ob.Girlsc[j].get_type();
					cou2++;
					break;
				}
			}
			if(cou2==0){
				for(j=0;j<ob.gd;j++){
				if((ob.Girlsd[j].getname()).equals(ob.Girls[i].getname())){
					gt = ob.Girlsd[j].get_type();
					cou2++;
					break;
				}
			}
			}
			if(cou2==0){
				for(j=0;j<ob.gn;j++){
				if((ob.Girlsn[j].getname()).equals(ob.Girls[i].getname())){
					gt = ob.Girlsn[j].get_type();
					cou2++;
					break;
				}
			}
			}
			for(j=0;j<40;j++) {
				if(!(ob.Boys[j].old.equals(ob.Girls[i].getname())) &&ob.Girls[i].get_st().equals("Single")&& ob.Girls[i].r.equals("y") && ob.Boys[j].get_st().equals("Single") && (ob.Boys[j].get_budget() >= ob.Girls[i].get_maintenance()) && (ob.Girls[i].get_attractiveness() >= ob.Boys[j].get_min())) {
					cou=0;
					t_s = new Timestamp(System.currentTimeMillis());
					
					ob.Boys[j].set_st("Committed");
					ob.Girls[i].set_st("Committed");
					ob.Girls[i].set_bf_name(ob.Boys[j].getname());
					
					if(cou==0){
						for(int x=0;x<ob.bm;x++){
						
							
							if((ob.Boysm[x]).equals((ob.Boys[j]).getname())){
								bt=ob.Boysm[x].get_type();
								cou++;
								break;
							}
						}
					}
					if(cou==0){
						for(int x=0;x<ob.bge;x++){
							if((ob.Boysge[x].getname()).equals(ob.Boys[j].getname())){
								bt=ob.Boysge[x].get_type();
								cou++;
								break;
							}
						}
					}
					if(cou==0){
						for(int x=0;x<ob.bgn;x++){
							if((ob.Boysgn[x].getname()).equals(ob.Boys[j].getname())){
								bt=ob.Boysgn[x].get_type();
								cou++;
								break;
							}
						}
					}
					c = new couples(ob.Girls[i].getname(),ob.Boys[j].getname(),z,ob.Girls[i].get_maintenance(),ob.Boys[j].get_budget(),gt,bt,ob.Girls[i].get_intelligence(),ob.Boys[j].get_intelligence(),ob.Girls[i].get_attractiveness(),ob.Boys[j].get_attractiveness());
					obj.Couple.add(c);
					z++;
					break;
				}
			}
		}
		obj.num = obj.Couple.size();
		for(couples cop : obj.Couple){
					r_w2.write(cop.bf_name+" is in a relationship with "+cop.gf_name);
					r_w2.newLine();
					System.out.println(cop.bf_name+" is in a relationship with "+cop.gf_name);
		}
		r_w2.close();
		f_w2.close();
		
		
	}
	
}
