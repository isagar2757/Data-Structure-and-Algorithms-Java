package exercise2;
import java.util.Scanner; 

public class Palindrome {
	
	public static boolean palindrome(String str) {
        int length = str.length();
    String input = str.toLowerCase();
    
	    if (length <= 1)
	    {
	        return true;
	    }
	    else
	    {
	    	if (input.charAt(0) == input.charAt(length-1))
	    	{
	    		palindrome(input.substring(1,length-1));
	    	}
	    	else
	    	{
	    		return false;
	    	}
	    	return true;
	    }
    }


	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
        
        System.out.println("Please Enter your string: ");
        String str = scan.nextLine();
        
        if(palindrome(str))
        {
            System.out.println("YES, String is Palindrome.");
        }
        else
        {
            System.out.println("No String is NOT Palindrome.");
        }


	}

}
