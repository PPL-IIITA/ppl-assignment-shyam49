import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
/**
*Class to generate random input for testing purpose.
*@author Shyam Kotecha
*/
public class testing_utility {
	
	public static girl Girls[] = new girl[10];
	public static boy Boys[] = new boy[20];	
	public static gift Gifts[] = new gift[20];	
	
	//Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";	

    //CSV file header
    private static final String FILE_HEADER_b = "name,intelligence_value,attractiveness,budget,min_attratctiveness,type,status";
	
	/**
	*Write random data generated to the csv-format file for boys.
	*/
    public static void writeCsvFile_b(String fileName) {
    	
	int z;
	boy b;
	for(int i=0;i<20;i++) {
		Random r = new Random();
		z = r.nextInt(3);
		if(z == 0) {
			b = new boy("b"+String.valueOf(i+1),(int)(Math.random()*15),(int)(Math.random()*10),(int)(Math.random()*100),(int)(Math.random()*10),"Miser","Single");
		}
		else if(z == 1) {
			b = new boy("b"+String.valueOf(i+1),(int)(Math.random()*15),(int)(Math.random()*10),(int)(Math.random()*100),(int)(Math.random()*10),"Generous","Single");
		}
		else {
			b = new boy("b"+String.valueOf(i+1),(int)(Math.random()*15),(int)(Math.random()*10),(int)(Math.random()*100),(int)(Math.random()*10),"Geek","Single");
		}
		Boys[i] = b;
	}
	FileWriter fileWriter = null;
	try {
		fileWriter = new FileWriter(fileName);
	
		//Write the CSV file header
           	fileWriter.append(FILE_HEADER_b.toString());
		
		//Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);
		
		for(boy boyz : Boys) {
			fileWriter.append(boyz.getname());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(boyz.get_intelligence()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(boyz.get_attractiveness()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(boyz.get_budget()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(boyz.get_min()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(boyz.get_type());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(boyz.get_st());
			fileWriter.append(NEW_LINE_SEPARATOR);
		}
	} catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

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
	girl g;
	for(int i=0;i<10;i++) {
		Random r = new Random();
		z = r.nextInt(3);
		if(z == 0) {
			g = new girl("g"+String.valueOf(i+1),(int)(Math.random()*15),(int)(Math.random()*10),(int)(Math.random()*100),"Single","Choosy"," ");
		}
		else if(z == 1) {
			g = new girl("g"+String.valueOf(i+1),(int)(Math.random()*15),(int)(Math.random()*10),(int)(Math.random()*100),"Single","Normal"," ");
		}
		else {
			g = new girl("g"+String.valueOf(i+1),(int)(Math.random()*15),(int)(Math.random()*10),(int)(Math.random()*100),"Single","Desperate"," ");
		}
		Girls[i] = g;
	}
	FileWriter fileWriter = null;
	try {
		fileWriter = new FileWriter(fileName);
	
		//Write the CSV file header
           	fileWriter.append(FILE_HEADER_g.toString());
		
		//Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);
		
		for(girl girlz : Girls) {
			fileWriter.append(girlz.getname());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(girlz.get_intelligence()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(girlz.get_attractiveness()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(girlz.get_maintenance()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(girlz.get_st());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(girlz.get_type());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(girlz.get_bf());	
			fileWriter.append(NEW_LINE_SEPARATOR);
		}
	} catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

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
	gift g;
	for(int i=0;i<20;i++) {
		Random r = new Random();
		z = r.nextInt(3);
		if(z == 0) {
			g = new gift("gift"+String.valueOf(i+1),(int)(Math.random()*100),(int)(Math.random()*100),"Essential");
		}
		else if(z == 1) {
			g = new gift("gift"+String.valueOf(i+1),(int)(Math.random()*100),(int)(Math.random()*100),"Luxury");
		}
		else {
			g = new gift("gift"+String.valueOf(i+1),(int)(Math.random()*100),(int)(Math.random()*100),"Utility");
		}
		Gifts[i] = g;
	}
	FileWriter fileWriter = null;
	try {
		fileWriter = new FileWriter(fileName);
	
		//Write the CSV file header
           	fileWriter.append(FILE_HEADER_gi.toString());
		
		//Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);
		
		for(gift giftz : Gifts) {
			fileWriter.append(giftz.get_name());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(giftz.get_price()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(giftz.get_value()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(giftz.get_type());
			fileWriter.append(NEW_LINE_SEPARATOR);
		}
	} catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

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
