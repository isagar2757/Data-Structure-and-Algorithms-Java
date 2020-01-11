package exercise2;


import java.util.Comparator;

class MergeSort {



public static <K> void merge(Queue<K> Q1, Queue<K> Q2, Queue<K> Q,Comparator<K> comp) 
{
	while (!Q1.isEmpty() && !Q2.isEmpty()) 
	{
		if (comp.compare(Q1.first(), Q2.first()) < 0)
		{
			Q.enqueue(Q1.dequeue()); 
		}
		else
		{
			Q.enqueue(Q2.dequeue());
		}
	}

	while (!Q1.isEmpty())
	{
		Q.enqueue(Q1.dequeue());
	}
 
	while (!Q2.isEmpty())
	{
		Q.enqueue(Q2.dequeue());
	}

}


public static <K> void mergeSort(Queue<K> S, Comparator<K> comp) 
{
	int n = S.size();
	
	if (n < 2) 
	{
		return;
	}
		
	Queue<K> S1 = new LinkedQueue<>(); 
	Queue<K> S2 = new LinkedQueue<>();
	
	while (S1.size() < n/2)
	{
		S1.enqueue(S.dequeue());
	}

	while (!S.isEmpty())
	{
		S2.enqueue(S.dequeue());
	}
		 
	mergeSort(S2, comp); 
	mergeSort(S1, comp); 

	merge(S2, S1, S, comp); 
}


  
public static void main(String[] args)
{
  
   Queue<Integer> S = new LinkedQueue<>();
	  S.enqueue(85);
	  S.enqueue(24);
	  S.enqueue(63);
	  S.enqueue(45);
	  S.enqueue(17);
	  S.enqueue(31);
	  S.enqueue(96);
	  S.enqueue(50);
  
   Comparator<Integer> comp = new Comparator<Integer>() {
   public int compare(Integer i1, Integer i2) {
   return i1.compareTo(i2);
   }
   };
  
   mergeSort(S, comp);
   System.out.println(S);
}
}

