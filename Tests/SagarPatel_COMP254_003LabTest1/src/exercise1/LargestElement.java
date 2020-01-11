package exercise1;

import java.util.Random;
import java.util.Scanner;

public class LargestElement {
	
	public static double[] find(double[] givenArray) {
		double[] testArray = givenArray;
		double[] resultArray = new double[5];
		for(int i=0; i<testArray.length;i++) {
			for(int j=0; j<5;j++) {
				if(resultArray != null) 
				{
					if(resultArray[j] < testArray[i])
					{
						resultArray[j] = testArray[i];
						 
					}
					
				}
				else
				{
					resultArray[j] = testArray[i++];
				}
				
			}
			
		}
		return resultArray;
		
	} 
	public static double[] fillArray(int n) 
	{
		double[] x = new double[n];
		 for(int i=0;i<n;i++)
		  {
			  double randomNumber = new Random().nextDouble();
			  x[i] = randomNumber;
		  }
		return x;
		
	}
	
public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
    System.out.println("Enter size of Array: ");
    int n = scan.nextInt();
    
		
		double[] givenArray = fillArray(n);
		
		
		 long startTime = System.currentTimeMillis();
		 double[] resultArray = find(givenArray);
		  long endTime = System.currentTimeMillis();
	 long elapsed = endTime - startTime;
	 for(int i=0; i<resultArray.length;i++) 
	 {
		 System.out.println(resultArray[i]);
	 }
	 System.out.println("Time elapsed:"+ elapsed);

	}

}
