import java.util.*;
import java.io.*;
/**
*Main class containing main method.
*@author Shyam Kotecha
*/
public class q6 {
	   /**
	   *main function 
	   *@param arg A string array containing 
   	   * the command line arguments.
	   * @exception IOException On input error.
	   * @see IOException	
	   */
	public static void main(String args[]) throws IOException {
		couple_gen ob = new couple_gen(); // Object of type couple_gen
		ob.couple_generator();
	}
}