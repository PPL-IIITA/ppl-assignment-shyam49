import java.util.*;
import java.io.*;
import java.sql.Timestamp;
/**
*
*q1 --- main program containing main method.
*@author Shyam Kotecha
*/
public class q1 {
	   /**
	   *main function 
	   *@param arg A string array containing 
   	   * the command line arguments.
	   * @exception IOException On input error.
	   * @see IOException	
	   */
	public static void main(String args[]) throws IOException {
		File f = new File("couples_formed.txt");
        	Boolean b = f.createNewFile();
        	FileWriter f_w;
        	BufferedWriter r_w;
       		f_w = new FileWriter("couples_formed.txt");	
        	r_w = new BufferedWriter(f_w);
		read_file ob = new read_file();
		ob.read_boys();
		ob.read_girls();
		Timestamp t_s = new Timestamp(System.currentTimeMillis());
		int i,j;
		r_w.write("\nCouples formed:\n");
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
					break;
				}
			}
		}
		r_w.close();
		f_w.	close();	
	}
}
