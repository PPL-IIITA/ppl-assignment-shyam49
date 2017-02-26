import java.util.*;
import java.io.*;
/**
*Class to read from files containing data of girls & boys.
*@author Shyam Kotecha
*/
public class read_file {
	public boy Boys[] = new boy[20];
	public girl Girls[] = new girl[10];
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
			Boys[i] = new boy(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),Integer.parseInt(array[3]),Integer.parseInt(array[4]),array[5]);
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
			Girls[j] = new girl(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),Integer.parseInt(array[3]),array[4],array[5]);
			j++;	
		}	
		br.close();
	}
}
