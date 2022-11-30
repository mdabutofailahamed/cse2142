import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList 
{
	public static void main(String[] args) 

	{
		if (args.length != 1)   // handle invalid number of arguments.
        {                 
            System.err.println("invalid"); 
        }
		
		// section: print all
		else if(args[0].equals(Constant.printAll))  
		{
			System.out.println(Constant.load);		
			
			try 
			{
				for(String j : readFile().readLine().split(Constant.comma)) 
				{ 
					System.out.println(j); 
				}
			} 
			catch (Exception e)
			{
			} 
			
			System.out.println(Constant.loaded);
		}
		
		// section: Print random data
		else if(args[0].equals(Constant.random)) 
		{
			System.out.println(Constant.load);			
			try 
			{				
				String nameOfStudents[] = readFile().readLine().split(",");
				
				System.out.println(nameOfStudents[new Random().nextInt(nameOfStudents.length)]);
			} 
			catch (Exception e)
			{
			} 
			System.out.println(Constant.loaded);			
		}
		
		// section: add new data  
		else if(args[0].contains(Constant.add))
		{
			System.out.println(Constant.load);			
			try 
			{
				BufferedWriter bufferedWriter = writeFile();
				
				String inputData = args[0].substring(1);
		        
		        String dateFormat = new SimpleDateFormat(Constant.df).format(new Date());
		        bufferedWriter.write(Constant.comma + inputData + Constant.lastUpdate + dateFormat);
		        bufferedWriter.close();
			} 
			catch (Exception e)
			{
			}
							
			System.out.println(Constant.loaded);	
		}
		
		// case: search data
		else if(args[0].contains(Constant.search)) 
		{
			System.out.println(Constant.load);			
			try 
			{
				String nameOfStudents[] = readFile().readLine().split(Constant.comma);	
				
				boolean found = false;
				
				for(String name : nameOfStudents)
				{
					if(name.equals(args[0].substring(1))) 
					{
						System.out.println(Constant.found);
						found = true;
					}
				}
			} catch (Exception e)
			{
			} 
			System.out.println(Constant.loaded);				
		}
		
		// case: count data
		else if(args[0].contains(Constant.count)) 
		{
			System.out.println(Constant.load);			
			try 
			{					
				System.out.println(readFile().readLine().split(Constant.comma).length + Constant.wordFound);
			} 
			catch (Exception e)
			{
			} 
			System.out.println(Constant.loaded);				
		}
		
		// handle invalid arguments.
		else
		{
			System.err.println(Constant.invalid);
            System.err.println(Constant.exit);
            System.exit(2);
		}
	}
	
    // Static method called: readFile() --> File Read Object
    private static BufferedReader readFile() throws FileNotFoundException 
    {
        BufferedReader bufferedReader = new BufferedReader(
        		new InputStreamReader
        				(new FileInputStream(Constant.studentsList)));
        
        return bufferedReader;
    }

    // Static method called: writeFile() --> File Write Object
    private static BufferedWriter writeFile() throws IOException 
    {
        BufferedWriter bufferedWriter = new BufferedWriter(
        		new FileWriter(
        				Constant.studentsList, true));
        
        return bufferedWriter;
    }
}
