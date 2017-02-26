import java.util.*;
import java.io.*;
/**
*Used to invoke methods of testing_utility class to create 2 separate input files.
*@author Shyam Kotecha
*/ 
public class random_gen {
	  /**
	   *main function to create csv files containing data of boys & girls.
	   *@param arg A string array containing 
   	   * the command line arguments.
	   * @exception IOException On input error.
	   * @see IOException	
	   */
	public static void main(String args[]) throws IOException{
		String fileName_b = "boys_list.csv";
        	testing_utility.writeCsvFile_b(fileName_b);
		
		String fileName_g = "girls_list.csv";
        	testing_utility.writeCsvFile_g(fileName_g);
	}
}
