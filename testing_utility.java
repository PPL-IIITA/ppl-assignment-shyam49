import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
*Class to generate random input for testing purpose.
*@author Shyam Kotecha
*/
public class testing_utility {
	
	public static girl Girls[] = new girl[10];
	public static boy Boys[] = new boy[20];	
	
	//Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";	

    //CSV file header
    private static final String FILE_HEADER_b = "name,intelligence_value,attractiveness,budget,min_attratctiveness,status";
	
	/**
	*Write random data generated to the csv-format file for boys.
	*/	
    public static void writeCsvFile_b(String fileName) {
    	
	boy b;
	for(int i=0;i<20;i++) {
		b = new boy("b"+String.valueOf(i+1),(int)(Math.random()*15),(int)(Math.random()*10),(int)(Math.random()*1500),(int)(Math.random()*10),"Single");
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
    private static final String FILE_HEADER_g = "name,intelligence_value,attractiveness,maintenance,status,boy_frnd_name";
	
	/**
	*Write random data generated to the csv-format file for girls.
	*/
	
    public static void writeCsvFile_g(String fileName) {
    	
	girl g;
	for(int i=0;i<10;i++) {
		g = new girl("g"+String.valueOf(i+1),(int)(Math.random()*15),(int)(Math.random()*10),(int)(Math.random()*1500),"Single"," ");
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
}
