import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
/**
*Class to generate random input for testing purpose.
*@author Shyam Kotecha
*/
public class testing_utility {
	
	public static girl_desperate Girlsd[] = new girl_desperate[10]; // Array of type girl_desperate.
	public static girl_choosy Girlsc[] = new girl_choosy[10]; // Array of type girl_choosy.
	public static girl_normal Girlsn[] = new girl_normal[10]; // Array of type girl_normal.
	public static boy_geek Boysge[] = new boy_geek[40]; // Array of type boy_geek.
	public static boy_generous Boysgn[] = new boy_generous[40]; // Array of type boy_generous.
	public static boy_miser Boysm[] = new boy_miser[40]; // Array of type boy_miser.
	public static gift_essential Giftse[] = new gift_essential[30];	// Array of type gift_essential.
	public static gift_luxury Giftsl[] = new gift_luxury[30]; // Array of type gift_luxury.	
	public static gift_utility Giftsu[] = new gift_utility[30]; // Array of type gift_utility.
	
	//Delimiter used in CSV file
   private static final String COMMA_DELIMITER = ","; // Comma delimiter to write to csv file.
    private static final String NEW_LINE_SEPARATOR = "\n"; // New line separator to write to csv file.		

    //CSV file header
    private static final String FILE_HEADER_b = "name,intelligence_value,attractiveness,budget,min_attratctiveness,type,status";
	
	/**
	*Write random data generated to the csv-format file for boys.
	*/
    public static void writeCsvFile_b(String fileName) {
    	
	int z;
	int o,t,th; // Auxiliary variables.
	o=0;t=0;th=0;
	boy_geek bge;
	boy_generous bgn;
	boy_miser bm;
	FileWriter fileWriter = null;
	try{
		fileWriter = new FileWriter(fileName);
		
		//Write the CSV file header
           	fileWriter.append(FILE_HEADER_b.toString());
		
		//Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR); }
                catch (Exception e) {
           		 System.out.println("Error in CsvFileWriter !!!");
           		 e.printStackTrace();
        	}
	for(int i=0;i<40;i++) {
		Random r = new Random();
		z = r.nextInt(3);
		if(z == 0) {
			bm = new boy_miser("b"+String.valueOf(i+1),(int)(Math.random()*15),(int)(Math.random()*10),(int)(Math.random()*100),(int)(Math.random()*10),"Miser","Single","");Boysm[o] = bm;
			try {
			fileWriter.append(Boysm[o].getname());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Boysm[o].get_intelligence()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Boysm[o].get_attractiveness()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Boysm[o].get_budget()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Boysm[o].get_min()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Boysm[o].get_type());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Boysm[o].get_st());
			fileWriter.append(NEW_LINE_SEPARATOR);}
			catch (Exception e) {
            			System.out.println("Error in CsvFileWriter !!!");
          			  e.printStackTrace();
       			 }
			o++;
		}
		else if(z == 1) {
			bgn = new boy_generous("b"+String.valueOf(i+1),(int)(Math.random()*15),(int)(Math.random()*10),(int)(Math.random()*100),(int)(Math.random()*10),"Generous","Single","");Boysgn[t] = bgn;
			try {
			fileWriter.append(Boysgn[t].getname());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Boysgn[t].get_intelligence()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Boysgn[t].get_attractiveness()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Boysgn[t].get_budget()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Boysgn[t].get_min()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Boysgn[t].get_type());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Boysgn[t].get_st());
			fileWriter.append(NEW_LINE_SEPARATOR); }
			catch (Exception e) {
            			System.out.println("Error in CsvFileWriter !!!");
            			e.printStackTrace();
       			 }
			t++;
		}
		else {
			bge = new boy_geek("b"+String.valueOf(i+1),(int)(Math.random()*15),(int)(Math.random()*10),(int)(Math.random()*100),(int)(Math.random()*10),"Geek","Single","");Boysge[th]=bge;
			try {
			fileWriter.append(Boysge[th].getname());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Boysge[th].get_intelligence()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Boysge[th].get_attractiveness()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Boysge[th].get_budget()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Boysge[th].get_min()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Boysge[th].get_type());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Boysge[th].get_st());
			fileWriter.append(NEW_LINE_SEPARATOR); }
			catch (Exception e) {
          			 System.out.println("Error in CsvFileWriter !!!");
            			e.printStackTrace();
      			  }
			th++;
		}
		
	}
	try {}
	finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

    	  }
	}	
    //CSV file header
    private static final String FILE_HEADER_g = "name,intelligence_value,attractiveness,maintenance,status,type,boy_frnd_name";
	
	/**
	*Write random data generated to the csv-format file for girls.
	*/
    public static void writeCsvFile_g(String fileName) {

	int z;    
	int o,t,th; // Auxiliary variables.
	o=0;t=0;th=0;	
	girl_choosy gc;
	girl_desperate gd;
	girl_normal gn;
	FileWriter fileWriter = null;
	try {
		fileWriter = new FileWriter(fileName);
		
		//Write the CSV file header
           	fileWriter.append(FILE_HEADER_g.toString());
		
		//Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);}
                catch (Exception e) {
           		 System.out.println("Error in CsvFileWriter !!!");
            		e.printStackTrace();
        	}
	for(int i=0;i<10;i++) {
		Random r = new Random();
		z = r.nextInt(3);
		if(z == 0) {
			gc = new girl_choosy("g"+String.valueOf(i+1),(int)(Math.random()*15),(int)(Math.random()*10),(int)(Math.random()*100),"Single","Choosy"," ","");Girlsc[o]=gc;
			try {
			fileWriter.append(Girlsc[o].getname());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Girlsc[o].get_intelligence()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Girlsc[o].get_attractiveness()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Girlsc[o].get_maintenance()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Girlsc[o].get_st());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Girlsc[o].get_type());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Girlsc[o].get_bf());	
			fileWriter.append(NEW_LINE_SEPARATOR); }
			catch (Exception e) {
           			 System.out.println("Error in CsvFileWriter !!!");
           			 e.printStackTrace();
       			 }
			o++;
		}
		else if(z == 1) {
			gn = new girl_normal("g"+String.valueOf(i+1),(int)(Math.random()*15),(int)(Math.random()*10),(int)(Math.random()*100),"Single","Normal"," ","");Girlsn[t]=gn;
			try {
			fileWriter.append(Girlsn[t].getname());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Girlsn[t].get_intelligence()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Girlsn[t].get_attractiveness()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Girlsn[t].get_maintenance()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Girlsn[t].get_st());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Girlsn[t].get_type());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Girlsn[t].get_bf());	
			fileWriter.append(NEW_LINE_SEPARATOR); }
			catch (Exception e) {
            			System.out.println("Error in CsvFileWriter !!!");
            			e.printStackTrace();
       			 }
			t++;
		}
		else {
			gd = new girl_desperate("g"+String.valueOf(i+1),(int)(Math.random()*15),(int)(Math.random()*10),(int)(Math.random()*100),"Single","Desperate"," ","");Girlsd[th]=gd;
			try {
			fileWriter.append(Girlsd[th].getname());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Girlsd[th].get_intelligence()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Girlsd[th].get_attractiveness()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Girlsd[th].get_maintenance()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Girlsd[th].get_st());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Girlsd[th].get_type());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Girlsd[th].get_bf());	
			fileWriter.append(NEW_LINE_SEPARATOR); }
			catch (Exception e) {
           			 System.out.println("Error in CsvFileWriter !!!");
           			 e.printStackTrace();
       			 }
			th++;
		}

	}
	try{}
	finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

    	  }
	
	}
	//CSV file header
    private static final String FILE_HEADER_gi = "gift_name,price,value,type";
	
	/**
	*Write random data generated to the csv-format file for gifts.
	*/
    public static void writeCsvFile_gi(String fileName) {
    	
	int z;
	int o,t,th; // Auxiliary variables.
	o=0;t=0;th=0;
	
	gift_utility gu;
	gift_essential ge;
	gift_luxury gl;
	FileWriter fileWriter = null;
	try{
		fileWriter = new FileWriter(fileName);
		
		//Write the CSV file header
           	fileWriter.append(FILE_HEADER_gi.toString());
		
		//Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR); }
                catch (Exception e) {
            		System.out.println("Error in CsvFileWriter !!!");
            		e.printStackTrace();
        	}
	for(int i=0;i<30;i++) {
		Random r = new Random();
		z = r.nextInt(3);
		if(z == 0) {
			ge = new gift_essential("gift"+String.valueOf(i+1),(int)(Math.random()*100),(int)(Math.random()*100),"Essential");
			Giftse[o]=ge;
			try {
			fileWriter.append(Giftse[o].get_name());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Giftse[o].get_price()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Giftse[o].get_value()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Giftse[o].get_type());
			fileWriter.append(NEW_LINE_SEPARATOR); }
			catch (Exception e) {
           	 		System.out.println("Error in CsvFileWriter !!!");
            			e.printStackTrace();
       	 		}
			o++;
		}
		else if(z == 1) {
			gl = new gift_luxury("gift"+String.valueOf(i+1),(int)(Math.random()*100),(int)(Math.random()*100),"Luxury");
			Giftsl[t]=gl;
			try {
			fileWriter.append(Giftsl[t].get_name());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Giftsl[t].get_price()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Giftsl[t].get_value()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Giftsl[t].get_type());
			fileWriter.append(NEW_LINE_SEPARATOR); }
			catch (Exception e) {
           			 System.out.println("Error in CsvFileWriter !!!");
          			  e.printStackTrace();
       			 }
			t++;
		}
		else {
			gu = new gift_utility("gift"+String.valueOf(i+1),(int)(Math.random()*100),(int)(Math.random()*100),"Utility");
			Giftsu[th]=gu;
			try {
			fileWriter.append(Giftsu[th].get_name());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Giftsu[th].get_price()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(Giftsu[th].get_value()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Giftsu[th].get_type());
			fileWriter.append(NEW_LINE_SEPARATOR); }
			catch (Exception e) {
            			System.out.println("Error in CsvFileWriter !!!");
           			 e.printStackTrace();
       			 }
			th++;
		}
		}
		try{}
		finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

    	  }
	}
	
}
