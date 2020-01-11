package ex3;



/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * A basic singly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class SinglyLinkedList<E> implements Cloneable {
  //---------------- nested Node class ----------------
  /**
   * Node of a singly linked list, which stores a reference to its
   * element and to the subsequent node in the list (or null if this
   * is the last node).
   */
  private static class Node<E> {

    /** The element stored at this node */
    private E element;            // reference to the element stored at this node

    private int index;
    /** A reference to the subsequent node in the list */
    private Node<E> next;         // reference to the subsequent node in the list

    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param n  reference to a node that should follow the new node
     */
    public Node(E e, Node<E> n) {
      element = e;
      next = n;
    }
    
    
    //Node with Index by sagar
    
    public Node(E e,int i, Node<E> n) {
        element = e;
        next = n;
        index = i;
      }

    // Accessor methods
    /**
     * Returns the element stored at the node.
     * @return the element stored at the node
     */
    public E getElement() { return element; }
    
    
   
    /**
     * Returns the node that follows this one (or null if no such node).
     * @return the following node
     */
    public Node<E> getNext() { return next; }

    // Modifier methods
    /**
     * Sets the node's next reference to point to Node n.
     * @param n    the node that should follow this one
     */
    public void setNext(Node<E> n) { next = n; }


	


//	public Node<E> prevTail() {
//		// TODO Auto-generated method stub
//		return null;
//	}
    
    
    
  } //----------- end of nested Node class -----------

  // instance variables of the SinglyLinkedList
  /** The head node of the list */
  private Node<E> head = null;               // head node of the list (or null if empty)

  /** The last node of the list */
  private Node<E> tail = null;               // last node of the list (or null if empty)

  /** Number of nodes in the list */
  private int size = 0;                      // number of nodes in the list

  /** Constructs an initially empty list. */
  public SinglyLinkedList() { }              // constructs an initially empty list

  // access methods
  /**
   * Returns the number of elements in the linked list.
   * @return number of elements in the linked list
   */
  public int size() { return size; }

  /**
   * Tests whether the linked list is empty.
   * @return true if the linked list is empty, false otherwise
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * Returns (but does not remove) the first element of the list
   * @return element at the front of the list (or null if empty)
   */
  public E first() {             // returns (but does not remove) the first element
    if (isEmpty()) return null;
    return head.getElement();
  }

  /**
   * Returns (but does not remove) the last element of the list.
   * @return element at the end of the list (or null if empty)
   */
  public E last() {              // returns (but does not remove) the last element
    if (isEmpty()) return null;
    return tail.getElement();
  }

  // update methods
  /**
   * Adds an element to the front of the list.
   * @param e  the new element to add
   */
  public void addFirst(E e) {                // adds element e to the front of the list
    head = new Node<>(e, head);              // create and link a new node
    if (size == 0)
      tail = head;                           // special case: new node becomes tail also
    size++;
  }

  /**
   * Adds an element to the end of the list.
   * @param e  the new element to add
 * @param i 
   */
  public void addLast(E e, int i) {                 // adds element e to the end of the list
    Node<E> newest = new Node<>(e, null);    // node will eventually be the tail
    if (isEmpty()) 
    {
      head = newest;                         // special case: previously empty list
    	head.index = i;
    	}
    else
      tail.setNext(newest);                  // new node after existing tail
    tail = newest;                           // new node becomes the tail
    tail.index = i;
    size++;
  }
  

   //Previous Node  for singly by sagar
  
  public Node<E> getPrev(Node<E> curr) {              // returns (but does not remove) the last element
	  Node walk = head; 
	  Node prev = null;
	  while(walk != null) 
	  {
		  if(walk.getNext() == curr) 
		  {
			  prev = walk;
		  }

		  
		  
		  walk = walk.getNext();
	  }
	  return prev;
  }
  
  
//get node on specific Index by sagar
  public E get(int i) { 
	  E element=null;
	  Node walk = head;
	  while(walk != null) 
	  {
		  if(i == walk.index) 
		  {
			  element = (E) walk.element;
		  }
		  walk = walk.getNext();
	  }
 	 
  	return element;
  	}
  
  
//set node element on specific Index by sagar 
  public void set(E e,int i) { 
	  E element=null;
	  Node walk = head;
	  while(walk != null) 
	  {
		  if(i == walk.index) 
		  {
			     walk.element = e;
			  break;
		  }
		  walk = walk.getNext();
	  }
 	 
  	}
  
//remove node on specific Index by sagar  
  public void remove(int i) { 
	  E element=null;
	  Node walk = head;
	  Node prev = null;
	  while(walk != null) 
	  {
		  if(i == walk.index) 
		  {
			 if(walk == head) 
			 {
				 head = walk.getNext();
				 //walk = null;
				 size--;
				
			 }
			 else if(walk == tail)
			 {
				 prev = getPrev(tail);
				 prev.setNext(null);
				 tail = prev;
				 size--;
			 }
			 else
			 {
				 prev = getPrev(walk);
				 prev.setNext(walk.getNext());
				 size--;
			 }
			  
		  }
		  walk = walk.getNext();
	  }
	  
 	 
  	}

  
  public void addLast(E e) {                 // adds element e to the end of the list
	    Node<E> newest = new Node<>(e, null);    // node will eventually be the tail
	    if (isEmpty())
	      head = newest;                         // special case: previously empty list
	    else
	      tail.setNext(newest);                  // new node after existing tail
	    tail = newest;                           // new node becomes the tail
	    size++;
	  }

  /**
   * Removes and returns the first element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeFirst() {                   // removes and returns the first element
    if (isEmpty()) return null;              // nothing to remove
    E answer = head.getElement();
    head = head.getNext();                   // will become null if list had only one node
    size--;
    if (size == 0)
      tail = null;                           // special case as list is now empty
    return answer;
  }

  @SuppressWarnings({"unchecked"})
  public boolean equals(Object o) {
    if (o == null) return false;
    if (getClass() != o.getClass()) return false;
    SinglyLinkedList other = (SinglyLinkedList) o;   // use nonparameterized type
    if (size != other.size) return false;
    Node walkA = head;                               // traverse the primary list
    Node walkB = other.head;                         // traverse the secondary list
    while (walkA != null) {
      if (!walkA.getElement().equals(walkB.getElement())) return false; //mismatch
      walkA = walkA.getNext();
      walkB = walkB.getNext();
    }
    return true;   // if we reach this, everything matched successfully
  }

  @SuppressWarnings({"unchecked"})
  public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
    // always use inherited Object.clone() to create the initial copy
    SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); // safe cast
    if (size > 0) {                    // we need independent chain of nodes
      other.head = new Node<>(head.getElement(), null);
      Node<E> walk = head.getNext();      // walk through remainder of original list
      Node<E> otherTail = other.head;     // remember most recently created node
      while (walk != null) {              // make a new node storing same element
        Node<E> newest = new Node<>(walk.getElement(), null);
        otherTail.setNext(newest);     // link previous node to this one
        otherTail = newest;
        walk = walk.getNext();
      }
    }
    return other;
  }

  public int hashCode() {
    int h = 0;
    for (Node walk=head; walk != null; walk = walk.getNext()) {
      h ^= walk.getElement().hashCode();      // bitwise exclusive-or with element's code
      h = (h << 5) | (h >>> 27);              // 5-bit cyclic shift of composite code
    }
    return h;
  }

  /**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = head;
    while (walk != null) {
      sb.append(walk.getElement());
      if (walk != tail)
        sb.append(", ");
      walk = walk.getNext();
    }
    sb.append(")");
    return sb.toString();
  }
  
  //concatenate
  public static <E> SinglyLinkedList<E> concatenate(SinglyLinkedList<E> L,
		  SinglyLinkedList<E> M)
		   {
		   //Create a new node v
		   Node<E> v = new Node<E>(null, null);
		   v = L.head; //point to head of L
		   //walk to the end of list L
		   while(v.getNext() != null)
		   v = v.getNext();
		   //link to list M
		   v.setNext(M.head);
		   SinglyLinkedList<E> C = L;
		   return C;
		   }
  
  // penultimate
  
  private Node<E> penultimate( ) {
	  if (size < 2)
	  throw new IllegalStateException("list must have 2 or more entries");
	  Node<E> walk = head;
	  //walk until the second-to-last node is reached
	  while (walk.getNext().getNext() != null)
	  walk = walk.getNext();
	  return walk;
	  }

  
  // Swapping Method
  @SuppressWarnings("unused")
public void swapNodes(E x, E y) {
	  Node <E> current = head;
	  Node <E> previous = null;
	  // ---- searching for x
	  while(current != null && current.getElement() != x) {
		  previous = current;
		  current = current.getNext();  
	  }
	  Node <E> nodeX = current;
	  Node <E> prevX = previous;
	  System.out.println(nodeX.getElement());
	  //System.out.println(prevX.getElement());

	  // ---- searching for y
	  current = head;
	  previous = null;
	  while(current != null && current.getElement() != y) {
		  previous = current;
		  current = current.getNext();  
	  }
	  Node <E> nodeY = current;
	  Node <E> prevY = previous;
	  System.out.println(nodeY.getElement());
	  System.out.println(prevY.getElement());
	  Node <E> temp;
	  temp = nodeY.getNext();
	  System.out.println(temp.getElement());

	  nodeY.setNext(nodeX.getNext());
	  nodeX.setNext(temp);
	  if(prevX == null) {
		  head = nodeY;                      
		  prevY.setNext(nodeX);
	  }
	  if(prevY == null) {
		  head = nodeX;                      
		  prevX.setNext(nodeY);
	  }
	  if(prevX != null && prevY != null) {
		  prevX.setNext(nodeY);
		  prevY.setNext(nodeY);
	  }
  }

  //main method
  public static void main(String[] args)
  {
  
  SinglyLinkedList<String> L = new SinglyLinkedList<String>();
  L.addFirst("MSP");
  L.addLast("ATL");
  L.addLast("BOS, ");
  L.addFirst("LAX");
  System.out.println(L);

  //create list M ...
  SinglyLinkedList<String> M = new SinglyLinkedList<String>();
  M.addFirst("OTA");
  M.addLast("TOR");
  M.addLast("CAL");
  M.addFirst("VAN");
  System.out.println(M);
  //concatenate L with M
  System.out.println(concatenate(L,M));
  
  System.out.println("second last in the list: "+
		  M.penultimate().getElement());
		   System.out.println("tail element in the list: "+M.tail.getElement());
  
}
  public SinglyLinkedList<E> concatenate(SinglyLinkedList<E> M) {
		   Node<E> v = this.tail;
		   v.setNext(M.head);
		   M.head = null;
		   return this;
	}
}
