import java.util.*;

public class NextHigherNumber {

    // https://www.geeksforgeeks.org/problems/next-greater-number-set-digits3503/1

    public static void main(String[] args) {

        findNext(143);

    }

    public static int findNext(int n) {
        // Convert the number to a character array of digits
        char[] digits = Integer.toString(n).toCharArray();
        int length = digits.length;

        // Step 1: Find the pivot
        int i;
        for (i = length - 2; i >= 0; i--) {
            if (digits[i] < digits[i + 1]) {
                break; // Found the pivot
            }
        }

        // If no pivot is found, return "not possible" as this is the highest permutation
        if (i < 0) {
            return -1;
        }

        // Step 2: Find the successor
        int j;
        for (j = length - 1; j > i; j--) {
            if (digits[j] > digits[i]) {
                break; // Found successor to swap with pivot
            }
        }

        // Step 3: Swap the pivot with the successor
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // Step 4: Reverse the digits after the pivot
        reverse(digits, i + 1, length - 1);

        String resultStr = new String(digits);
        return Integer.parseInt(resultStr);// Return as string, or you can convert it to int

    }

    // Helper function to reverse the part of an array
    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
