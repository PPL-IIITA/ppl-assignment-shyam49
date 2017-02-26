import java.util.*;
import java.io.*;
/**
*Class to read from files containing data of girls, boys & gifts.
*@author Shyam Kotecha
*/
public class read_file {
	public boy Boys[] = new boy[20];
	public girl Girls[] = new girl[10];
	public ArrayList<gift> Gifts = new ArrayList<>();
	/**
	*Method to read data for boys.
	* @exception IOException On input error.
	* @see IOException
	*/
	public void read_boys() throws IOException{
		File file = new File("boys_list.csv");
		BufferedReader br = new BufferedReader(new FileReader("boys_list.csv"));
		String line;
		int i=0;	
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
		File file = new File("girls_list.csv");
		BufferedReader br = new BufferedReader(new FileReader("girls_list.csv"));
		String line;
		int j=0;	
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
		File file = new File("gifts_list.csv");
		BufferedReader br = new BufferedReader(new FileReader("gifts_list.csv"));
		String line;
		gift g;
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
