import java.util.*;
import java.io.*;
/**
*Class to read from files containing data of girls, boys & gifts.
*@author Shyam Kotecha
*/
public class read_file {
	public boy Boys[] = new boy[60]; // Array of type boy.
	public girl Girls[] = new girl[10]; // Array of type girl.
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
		int i=0; // Loop variable.	
		line = br.readLine();
		while ((line = br.readLine()) !=null){
			String[] array = line.split(",");
			Boys[i] = new boy(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),Integer.parseInt(array[3]),Integer.parseInt(array[4]),array[5],array[6]);
			i++;	
		}	
		br.close();
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
		int j=0; // Loop variable.
		line = br.readLine();
		while ((line = br.readLine()) !=null){
			String[] array = line.split(",");
			Girls[j] = new girl(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),Integer.parseInt(array[3]),array[4],array[5],array[6]);
			j++;	
		}	
		br.close();
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
		gift g; // Object of type gift.
		int i=0;	
		line = br.readLine();
		while ((line = br.readLine()) !=null){
			String[] array = line.split(",");
			g = new gift(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),array[3]);
			Gifts.add(g);
			i++;	
		}	
		br.close();
	}
}
