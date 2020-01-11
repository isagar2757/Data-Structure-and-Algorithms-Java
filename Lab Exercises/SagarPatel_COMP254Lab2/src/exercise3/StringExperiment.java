package exercise3;

import java.util.Arrays;
import java.util.Random;




public class StringExperiment {

  /** Uses repeated concatenation to compose a String with n copies of character c. */
	public static boolean unique1(int[] data) {
	    int n = data.length;
	    for (int j=0; j < n-1; j++)
	      for (int k=j+1; k < n; k++)
	        if (data[j] == data[k])
	          return false;                    // found duplicate pair
	    return true;                           // if we reach this, elements are unique
	  }

	  /** Returns true if there are no duplicate elements in the array. */
	  public static boolean unique2(int[] data) {
	    int n = data.length;
	    int[] temp = Arrays.copyOf(data, n);   // make copy of data
	    Arrays.sort(temp);                     // and sort the copy
	    for (int j=0; j < n-1; j++)
	      if (temp[j] == temp[j+1])            // check neighboring entries
	        return false;                      // found duplicate pair
	    return true;                           // if we reach this, elements are unique
	  }

 
  public static void main(String[] args) 
  {

	 // int[] x = fillArray(100000000);
	  int[] x = fillArray(100000);
	  
	  int result = binarySearch(x,0,x.length,600);
	//  int result = binarySearch(x,0,x.length,60000);	//very slow
	  if (result == -1) 
          System.out.println("Value of N should be:" + x.length); 
      else
          System.out.println("Value of N should be: " + result); 
	  
 int result2 = binarySearchUnique2(x,0,x.length,6);
	  
	  if (result2 == -1) 
          System.out.println("Element not present"); 
      else
          System.out.println("Value of N should be: " + result2); 
	 
	 

	  
  }
  public static int[] fillArray(int n) 
  {
  	int[] x = new int[n];
  	 for(int i=0;i<n;i++)
  	  {
  		 // int randomNumber = new Random().nextInt();
  		  //x[i] = randomNumber;
  		 x[i] = i;
  	  }
  	return x;
  	
  }
  public static long runningTimeUni1(int n) 
  {
	  int[] x = fillArray(n);
  	
  	  long startTime = System.currentTimeMillis();
  	  boolean uni1 = unique1(x);
  	  long endTime = System.currentTimeMillis();
   long elapsed = endTime - startTime;
  	return elapsed;
  	
  }
  
  public static long runningTimeUni2(int n) 
  {
	  int[] x = fillArray(n);
  	
  	  long startTime = System.currentTimeMillis();
  	  boolean uni2 = unique2(x);
  	  long endTime = System.currentTimeMillis();
   long elapsed = endTime - startTime;
  	return elapsed;
  	
  }
  

  
  static int binarySearch(int arr[], int l, int r, long x) 
  { 
	  int mid = l + (r - l) / 2; 
      if (r >= l) { 
          //int mid = l + (r - l) / 2; 

         
          if (runningTimeUni1(mid) == x) 
              return mid; 

          
          if (runningTimeUni1(mid) > x) 
              return binarySearch(arr, l, mid - 1, x); 

          
          return binarySearch(arr, mid + 1, r, x); 
      } 

      
      return mid; 
  } 
  
  static int binarySearchUnique2(int arr[], int l, int r, long x) 
  {  
	  int mid = l + (r - l) / 2; 
      if (r >= l) { 
         

         
          if (runningTimeUni2(mid) == x) 
              return mid; 

          
          if (runningTimeUni2(mid) > x) 
              return binarySearchUnique2(arr, l, mid - 1, x); 

          
          return binarySearchUnique2(arr, mid + 1, r, x); 
      } 

      
      return mid; 
  } 

     
     
  }

