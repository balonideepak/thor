import java.util.*;

public class PrintPermutations2 {

  //swap function to swap two characters from indices idx and idx2
  public static void swap(char[] arr, int idx, int idx2) {
    char temp = arr[idx];
    arr[idx] = arr[idx2];
    arr[idx2] = temp;
  }

  public static void solve(char[] arr, int idx) {
    if (idx == arr.length - 1) { //Base condition of recursion
      System.out.print(String.valueOf(arr) + " ");
    }

    for (int i = idx; i < arr.length; i++) {
      swap(arr, idx, i);
      solve(arr, idx + 1);
      swap(arr, idx, i);
      //Backtracking: reverting all the elements to their original places
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    System.out.print("Enter string to generate its permutations: ");
    String str = scn.next(); //String input from the user
    if (str.length() == 0 || str == null) {
      return;
    }
    solve(str.toCharArray(), 0); //function call to find all the permutations
    //toCharArray() converts a given string into a character array
  }
}