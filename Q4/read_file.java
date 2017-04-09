import java.util.*;
import java.io.*;
/**
*Class to read from files containing data of girls, boys & gifts.
*@author Shyam Kotecha
*/
public class read_file {
	public boy_geek Boysge[] = new boy_geek[40]; // Array of type boy_geek.
	public boy_generous Boysgn[] = new boy_generous[40]; // Array of type boy_generous.
	public boy_miser Boysm[] = new boy_miser[40]; // Array of type boy_miser.
	public girl_choosy Girlsc[] = new girl_choosy[10]; // Array of type girl_choosy.
	public girl_desperate Girlsd[] = new girl_desperate[10]; // Array of type girl_desperate.
	public girl_normal Girlsn[] = new girl_normal[10]; // Array of type girl_normal.
	public boy Boys[] = new boy[40]; // Array of type boy.
	public girl Girls[] = new girl[10]; // Array of type girl.
	public int bm=0; // No. of miser boys.
	public int bgn=0;// No. of generous boys.
	public int bge=0;// No. of geek boys.
	public int gc=0;// No. of choosy girls.
	public int gn=0;// No. of normal girls.
	public int gd=0;// No. of desperate girls.
	public ArrayList<gift_utility> Giftsu = new ArrayList<>(); // List of utility gifts.
	public ArrayList<gift_essential> Giftse = new ArrayList<>(); // List of essential gifts.
	public ArrayList<gift_luxury> Giftsl = new ArrayList<>(); // List of luxury gifts.
	public ArrayList<gift> Gifts = new ArrayList<>(); // List of gifts.
	/**
	*Method to read data for boys.
	* @exception IOException On input error.
	* @see IOException
	*/
	public void read_boys() throws IOException{
		File file = new File("boys_list.csv"); // Object of type File to open the file.
		BufferedReader br = new BufferedReader(new FileReader("boys_list.csv")); // Object of type BufferedWriter.
		String line; // Variable to read line from file.
		int i=0;int j,k;j=0;k=0; // Loop variables.	
		line = br.readLine();
		int b=0;
		while ((line = br.readLine()) !=null){
			String[] array = line.split(",");
			if(array[5].equals("Geek")) {
				Boysge[i] = new boy_geek(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),Integer.parseInt(array[3]),Integer.parseInt(array[4]),array[5],array[6],"");
				i++; }
			else if(array[5].equals("Generous")) {
				Boysgn[j] = new boy_generous(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),Integer.parseInt(array[3]),Integer.parseInt(array[4]),array[5],array[6],"");
				j++; }
			else if(array[5].equals("Miser")) {
				Boysm[k] = new boy_miser(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),Integer.parseInt(array[3]),Integer.parseInt(array[4]),array[5],array[6],"");
				k++; }
			Boys[b] = new boy(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),Integer.parseInt(array[3]),Integer.parseInt(array[4]),array[6],"");
			b++;
		}	
		br.close();
		bge=i;bm=k;bgn=j;
	}
	
	/**
	*Method to read data for girls.
	* @exception IOException On input error.
	* @see IOException
	*/
	public void read_girls() throws IOException{
		File file = new File("girls_list.csv"); // Object of type File to open the file.
		BufferedReader br = new BufferedReader(new FileReader("girls_list.csv")); // Object of type BufferedWriter.
		String line; // Variable to read line from file.
		int i=0;int j,k;j=0;k=0; // Loop variables.
		line = br.readLine();
		int g=0;
		while ((line = br.readLine()) !=null){
			String[] array = line.split(",");
			if(array[5].equals("Desperate")) {
				Girlsd[i] = new girl_desperate(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),Integer.parseInt(array[3]),array[4],array[5],array[6],"");
				i++; }	
			else if(array[5].equals("Normal")) {
				Girlsn[j] = new girl_normal(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),Integer.parseInt(array[3]),array[4],array[5],array[6],"");
				j++; }
			else if(array[5].equals("Choosy")) {
				Girlsc[k] = new girl_choosy(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),Integer.parseInt(array[3]),array[4],array[5],array[6],"");
				k++; }
			Girls[g]= new girl(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),Integer.parseInt(array[3]),array[4],array[6],"");
			g++;
		}	
		br.close();
		gc=k;gn=j;gd=i;
	}

	/**
	*Method to read data for gifts.
	* @exception IOException On input error.
	* @see IOException
	*/
	public void read_gifts() throws IOException{
		File file = new File("gifts_list.csv"); // Object of type File to open the file.
		BufferedReader br = new BufferedReader(new FileReader("gifts_list.csv")); // Object of type BufferedWriter.
		String line; // Variable to read line from file.
		gift_luxury gl; // Reference variable of type gift_luxury.
		gift_utility gu; // Reference variable of type gift_utility.
		gift_essential ge; // Reference variable of type gift_essential.
		int i=0;	
		int g=0;
		gift gzz;
		line = br.readLine();
		while ((line = br.readLine()) !=null){
			String[] array = line.split(",");
			if(array[3].equals("Essential")) {
				ge = new gift_essential(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),array[3]);
				Giftse.add(ge); }
			else if(array[3].equals("Utility")) {
				gu = new gift_utility(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),array[3]);
				Giftsu.add(gu); }
			else if(array[3].equals("Luxury")) {
				gl = new gift_luxury(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),array[3]);
				Giftsl.add(gl); }
			gzz = new gift(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]));
			Gifts.add(gzz);
		}	
		br.close();
	}
}
