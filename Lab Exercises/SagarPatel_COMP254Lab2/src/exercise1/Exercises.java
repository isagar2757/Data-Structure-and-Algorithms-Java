package exercise1;
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
 * Code for end-of-chapter exercises on asymptotics.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class Exercises {

  /** Returns the sum of the integers in given array. */
	//O(n)
  public static int example1(int[] arr) {
    int n = arr.length, total = 0; // 3
    for (int j=0; j < n; j++)       // 2n
      total += arr[j]; // 3(n)
    return total; // 1
  } // 5n + 4  => c=6, n0 = 4

  /** Returns the sum of the integers with even index in given array. */
  //O(n)
  public static int example2(int[] arr) {
    int n = arr.length, total = 0; // 3
    for (int j=0; j < n; j += 2)    // n
      total += arr[j]; // 3{n/2}
    return total; // 1
  } // 5n/2 + 4 => c=3, n0=8

  /** Returns the sum of the prefix sums of given array. */
  //O(n^2)
  public static int example3(int[] arr) {
    int n = arr.length, total = 0; //3
    for (int j=0; j < n; j++)       // 2n
      for (int k=0; k <= j; k++)    // n(n+1)/2
        total += arr[j];		//	3{n(n+1)/2}
    return total;	//1
  } // 2n^2 + 4n +4 => c=3 and n0 = 4 , 8

  /** Returns the sum of the prefix sums of given array. */
  //O(n)
  public static int example4(int[] arr) {
    int n = arr.length, prefix = 0, total = 0;	//4
    for (int j=0; j < n; j++) {     // 2n
      prefix += arr[j];	// 3(n)
      total += prefix;	// 2(n)
    }
    return total; //1
  } 	// 7n + 5 => c= 8, n0= 5

  /** Returns the number of times second array stores sum of prefix sums from first. */
  //O(n^3)
  public static int example5(int[] first, int[] second) { 
    int n = first.length, count = 0;	// 3
    for (int i=0; i < n; i++) {     // 2n
      int total = 0;	//n
      for (int j=0; j < n; j++)     // 4n^2
        for (int k=0; k <= j; k++)  // n * n (n+1)/2
          total += first[k]; // 3{n * n (n+1)/2}
      if (second[i] == total) // 2{n * n (n+1)/2}
    	  count++; //n * n (n+1)/2
    }
    return count;// 1
  } // 7n^3/2 + 15n^2/2 + 3n + 4 => c= 4 and n0 = 8 , 14, 29

}
