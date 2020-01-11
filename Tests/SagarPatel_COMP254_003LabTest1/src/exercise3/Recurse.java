package exercise3;

public class Recurse {
	static int min = 100;
	public static int minE(int[] data, int n) {
		if(n<0) {
			return min;
		}
		if(min == 0) {
			min= data[n];
		}
		else
		{
			if(data[n]< min)
				min = data[n];
			
		}
	    
	      return minE(data, n-1);
	  }
	public static int[] fillArray(int n) 
	  {
	  	int[] x = new int[n];
	  	 for(int i=0;i<n;i++)
	  	  {
	  		 x[i] = i+10;
	  	  }
	  	return x;
	  	
	  }
	public static void main(String[] args) {
		int[] x = fillArray(100);
		int minVal = minE(x,99);
		System.out.println("Min Value is: " +  minVal);
	}
}
