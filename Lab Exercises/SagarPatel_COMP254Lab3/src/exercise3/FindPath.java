package exercise3;
import java.util.Scanner;
import java.io.File;

public class FindPath {
	
	public static void find(File path, String fileName) {
		
		File[] list = path.listFiles();
		if(list != null)
		{
			for(File file : list)
			{
				if(file.isDirectory())
				{
					find(file, fileName);
				}
				else if(fileName.equalsIgnoreCase(file.getName()))
				{
					System.out.println(file.getAbsolutePath());
				}
			}
			
		}
	}

	public static void main(String[] args) {
		
	      Scanner sc = new Scanner(System.in);
	      
	      System.out.print("filename with extension: ");
	      String filename = sc.next();
	      
	      System.out.print("path from where you want to start: ");// for mac it starts from  /Users/
	      String path = sc.next();
	      
		  find(new File(path), filename);
	      
	  }
}
