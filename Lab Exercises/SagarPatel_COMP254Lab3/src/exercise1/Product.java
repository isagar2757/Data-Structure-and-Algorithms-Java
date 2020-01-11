package exercise1;
import java.util.Scanner; 

public class Product {
	
    public static int product(int m, int n) {
        int answer=0;
        if (n == 0 || m == 0)
        {
            answer = 0;
        }
        else
        {
            if(m > 0 && n > 0)
            {
                answer = m + product(m, n - 1);
                
            }
            else
            {
                System.out.println("Enter only positive values please");
                System.exit(0);
            }
        }
        return answer;

    }

	public static void main(String[] args) {
	

        System.out.println("Product of m and n is:  " + product(4,5));

	}

}
