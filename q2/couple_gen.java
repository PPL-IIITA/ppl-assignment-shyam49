import java.util.*;
import java.io.*;
import java.sql.Timestamp;
import java.lang.*;
class fun implements Comparator<gift> {
	public int compare(gift g1,gift g2) {
		return g1.price - g2.price;
	}
}
class comp_happy implements Comparator<couples> {
	public int compare(couples c1,couples c2) {
		return c2.happiness_value - c1.happiness_value;
	}
}
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
	read_file ob = new read_file();
	aux obj = new aux();
	/**
	*To generate couples.
	* @exception IOException On input error.
	* @see IOException
	*/
	public void couple_generator() throws IOException{

		File f = new File("couples.txt");
        	Boolean b = f.createNewFile();
        	FileWriter f_w;
        	BufferedWriter r_w;
       		f_w = new FileWriter("couples.txt");
        	r_w = new BufferedWriter(f_w);
		couples c;
		ob.read_boys();
		ob.read_girls();
		Timestamp t_s = new Timestamp(System.currentTimeMillis());
		int i,j,z;
		int id;
		z = 1;
		id=0;
		r_w.write("\nCouples formed:\n");
		r_w.newLine();
		System.out.println("\nCouples formed:\n");
		for(i=0;i<10;i++) {
			for(j=0;j<20;j++) {
				if(ob.Boys[j].get_st().equals("Single") && (ob.Boys[j].get_budget() >= ob.Girls[i].get_maintenance()) && (ob.Girls[i].get_attractiveness() >= ob.Boys[j].get_min())) {
					t_s = new Timestamp(System.currentTimeMillis());
					r_w.write(t_s+" "+ob.Boys[j].getname()+" is in a relationship with "+ob.Girls[i].getname());
					r_w.newLine();
					System.out.println(t_s+" "+ob.Boys[j].getname()+" is in a relationship with "+ob.Girls[i].getname());
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
		
		File f = new File("gifts.txt");
        	Boolean b = f.createNewFile();
        	FileWriter f_w;
        	BufferedWriter r_w;
       		f_w = new FileWriter("gifts.txt");
        	r_w = new BufferedWriter(f_w);
		ob.read_gifts();
		Timestamp t_s = new Timestamp(System.currentTimeMillis());
		Collections.sort(ob.Gifts,new fun());
		int i,j;	
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
		int i,j;
		int happy;
		
		for(i=0;i<obj.num;i++) {
			happy=0;
			int maintenance = obj.Couple.get(i).get_main();
			long tot_val,tot_price;
			tot_val=0;
			tot_price=0;
			for(j=0;j<ob.Gifts.size();j++) {
				tot_price += ob.Gifts.get(i).get_price();
				tot_val += ob.Gifts.get(i).get_value();
			}
			if(obj.Couple.get(i).gf_type.equals("Choosy")) {
				tot_price -= maintenance;
				tot_price = Math.abs(tot_price);
				tot_price += tot_val;
				for(j=0;j<ob.Gifts.size();j++) {
					if(ob.Gifts.get(j).get_type().equals("Luxury")) {
						tot_price += ob.Gifts.get(j).get_value();
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
		int k;
		File f = new File("op2_happy&comp.txt");
        	Boolean b = f.createNewFile();
        	FileWriter f_w;
        	BufferedWriter r_w;
       		f_w = new FileWriter("op2_happy&comp.txt");
        	r_w = new BufferedWriter(f_w);
		System.out.println("\nenter value of k\n");
		Scanner s = new Scanner(System.in);
		k = s.nextInt();
		r_w.write("\n\n\nHappiness and compatibility:\n");
		r_w.newLine();
		System.out.println("\n\n\nHappiness and compatibility:\n");
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
		if(k>obj.Couple.size()) {
			for(int i=0;i<obj.Couple.size();i++) {
				System.out.println(obj.Couple.get(i).get_bf()+" "+obj.Couple.get(i).get_gf()+" happiness value = "+obj.Couple.get(i).get_happy());
			}
		}
		else {
			for(int i=0;i<k;i++) {
				System.out.println(obj.Couple.get(i).get_bf()+" "+obj.Couple.get(i).get_gf()+" happiness value = "+obj.Couple.get(i).get_happy());
			}
		}
		Collections.sort(obj.Couple,new comp_compat());
		System.out.println("\n\nSorting on the basis of compatibility value\n");
		for(int i=0;i<obj.Couple.size();i++) {
			r_w.write(obj.Couple.get(i).get_bf()+" "+obj.Couple.get(i).get_gf()+" compatibility value = "+obj.Couple.get(i).get_compat());
			r_w.newLine();
			System.out.println(obj.Couple.get(i).get_bf()+" "+obj.Couple.get(i).get_gf()+" compatibility value = "+obj.Couple.get(i).get_compat());
		}
		System.out.println("\n\ntop k compatible couples\n");
		if(k > obj.Couple.size()) {
			for(int i=0;i<obj.Couple.size();i++) {
				System.out.println(obj.Couple.get(i).get_bf()+" "+obj.Couple.get(i).get_gf()+" compatibility value = "+obj.Couple.get(i).get_compat());
			}
		}
		else {
			for(int i=0;i<k;i++) {
				System.out.println(obj.Couple.get(i).get_bf()+" "+obj.Couple.get(i).get_gf()+" compatibility value = "+obj.Couple.get(i).get_compat());
			}
		}
		r_w.close();
		f_w.close();
	}
	
}
