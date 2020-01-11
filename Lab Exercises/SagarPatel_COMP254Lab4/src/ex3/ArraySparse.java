package ex3;



public class ArraySparse<E> {

	private SinglyLinkedList<E> L = new SinglyLinkedList<>(); 
	
	public ArraySparse() {		
	}
	
	
	  public void add(E element, int i) 
	  { 
		  L.addLast(element, i); 
	  }
	  public E get(int i) 
	  { 
		  return L.get(i); 
	  }
	  public void set(E element, int i) 
	  { 
		  L.set(element, i); 
	  }
	  public void remove(int i) 
	  { 
		  L.remove(i); 
	  }
	
	  public int size() 
	  { 
		  return L.size(); 
	  }
	  public boolean isEmpty() 
	  {
		  return L.isEmpty(); 
	  }
	
	  public String toString() 
	  {
        return L.toString();
      }
   
	//using DoublyLinkedList
	
//private DoublyLinkedList<E> L = new DoublyLinkedList<>(); 
//	
//	public ArraySparse() {		
//	}
//	
//	public int size() { 
//		return L.size(); 
//		}
//	
//	public E get(int i) { 
//		return L.getelement(i); 
//		}
//	
//	public void remove(int i) { 
//		 L.remove(i); 
//		}
//	public boolean isEmpty() {
//		return L.isEmpty(); 
//		}
////	
//    public void addElement(E element, int i) { 
//    	L.addLast(element, i); 
//    	}
//   
//    public void set(E element, int i) { 
//    	L.set(element, i); 
//    	}
//    
//    public String toString() {
//        return L.toString();
//      }
//    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,0,2,0,3,0,4,0,0,0,0,0,0,0,0,0,0,0,5,0,6};
		
		ArraySparse<Integer> arraySparse = new ArraySparse<Integer>();
		for(int i = 0; i< A.length; i++) 
		{
			if(A[i] != 0 ) 
			{
				arraySparse.add(A[i], i);
			}
		}	
		
		
		System.out.println("Original Array: "+arraySparse.toString());
		System.out.println("Size of Sparse Array: "+arraySparse.size());
		System.out.println("Element at index 4: "+arraySparse.get(4));
		arraySparse.set(99,6);
		System.out.println("Element at index 6 changed to 99: "+arraySparse.toString());
		System.out.println("Element at index 6: "+arraySparse.get(6));
		arraySparse.remove(6);
		System.out.println("Remove element from index 6: "+arraySparse.toString());
		System.out.println("Size of Sparse Array: "+arraySparse.size());	
		
		
		//Using DoublyLinkedList
		
//		System.out.println(arraySparse.toString());	
//		System.out.println(arraySparse.get(4));
//		arraySparse.set(99,6);
//		System.out.println(arraySparse.toString());
//		System.out.println(arraySparse.get(6));
//		arraySparse.remove(6);
//		System.out.println(arraySparse.toString());
//		System.out.println(arraySparse.size());	
        }		
	}
