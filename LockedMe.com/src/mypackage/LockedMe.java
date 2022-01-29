package mypackage;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe {
	
	static final String projectfilespath = "E:\\LockedMeFiles";
	static final String errorMessage = "Some error occured. Please contact : admin@lockedme.com";

	public static void main(String[] args) {
	
		Scanner obj = new Scanner(System.in);
		int ch;
		
		do
		{
			displayMenu();
			System.out.println("Enter your choice:");
			ch=Integer.parseInt(obj.nextLine());
			
			switch(ch)
			{
				case 1:getAllFiles();
				break;
				case 2:createFiles();
				break;
				case 3:deleteFiles();
				break;
				case 4:searchFiles();
				break;
				case 5:System.exit(0);
				break;
				default:System.out.println("Invalid Option");
				break;
			}
			
		}
		while(ch>0);
		obj.close();
	}
	
	public static void displayMenu()
	{
		System.out.println("***************************************************************************");
		System.out.println("\t\tWelcome to Lockedme.com");
		System.out.println("\t\t\tDesigned By");
		System.out.println("\t\tMr. Vitthal Eknath Ingole");
		System.out.println("***************************************************************************");
		System.out.println("\t\t1. Display all the files");
		System.out.println("\t\t2. Add a new file");
		System.out.println("\t\t3. Delete a file");
		System.out.println("\t\t4. Search a file");
		System.out.println("\t\t5. EXIT");
	}
	
	/**
	 * This function will return all the files from the project directory
	 */
	public static void getAllFiles()
	{
		try
		{
		    File folder = new File(projectfilespath);
		    File[] listOfFiles = folder.listFiles();
		
		    if(listOfFiles.length==0)
			    System.out.println("No files exist in the directury");
		    else
	    	{
		       for(var l:listOfFiles)
		      {
			   System.out.println(l.getName());
		      }
		}
	  }
	  catch(Exception Ex)
	  {
		System.out.println(errorMessage);
	  }
	}
	
	/**
	 * This function will Create file in the project directory
	 */
	public static void createFiles() 
	{
		try
		{
		Scanner obj = new Scanner(System.in);
		
		String fileName;
		
		System.out.println("Enter file name:");
		fileName = obj.nextLine();
		
		int linesCount;
		System.out.println("Enter how many lines in the file:");
		linesCount=Integer.parseInt(obj.nextLine());
		
		FileWriter myWriter = new FileWriter(projectfilespath+ "\\"+ fileName);
		
		for(int i=0;i<linesCount;i++)
		{
			System.out.println("Enter the file line");
			myWriter.write(obj.nextLine()+"\n");
		}
		
		System.out.println("File Created Successfully");
		myWriter.close();
		
	}
	catch(Exception Ex)
	{
    	System.out.println(errorMessage);
	}
}
	
	/**
	 * This method will delete file base on provided file name
	 */
	public static void deleteFiles()
	{
		Scanner obj = new Scanner(System.in);
		
	   try
	   {
	        String fileName;
	   
	        System.out.println("Enter the file name to be deleted:");
		    
		    fileName = obj.nextLine();
	   
	    	File file = new File(projectfilespath+ "\\"+ fileName);
	     
	        if(file.exists())
	        {
	        	file.delete(); 
	        	System.out.println("File deleted successfully : "+fileName);
	        }
	        else
	        	System.out.println("File do not exist");
	   }	
	   catch(Exception Ex)
	   {
		   System.out.println(errorMessage);
	   }
	
	}
	
	/**
	 * This method will search files from the directory
	 */
	
	public static void searchFiles()
	{
		Scanner obj = new Scanner(System.in);
		
		   try
		   {
		        String fileName;
		   
		        System.out.println("Enter the file name to be searched:");
			    
			    fileName = obj.nextLine();
			    
		
			    File folder = new File(projectfilespath);
			    File[] listOfFiles = folder.listFiles();
			    
			    LinkedList<String> filenames = new LinkedList<String>();
			    
			    for(var l:listOfFiles)
			    	filenames.add(l.getName());
			    
			    if(filenames.contains(fileName))
			    	System.out.println("File is available");
			    else
			    	System.out.println("File is not available");
		   
		   }	
		   catch(Exception Ex)
		   {
			   System.out.println(errorMessage);
		   }
	}
	

}
