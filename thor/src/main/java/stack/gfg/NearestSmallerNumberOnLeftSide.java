package stack.gfg;

import java.util.Stack;

public class NearestSmallerNumberOnLeftSide {

    public static void main(String[] args) {
        int[] arr = {1, 3, 0, 2, 5};
        printPrevSmaller(arr);
    }
    public static void printPrevSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        // Traverse all elements in arr
        for (int i = 0; i < arr.length; i++) {

            // Remove elements from stack that are greater
            // than or equal to arr[i]
            while (!stack.isEmpty() && stack.peek() >= arr[i])
                stack.pop();

            // Print "_" if stack is empty, else print top of stack
            if (stack.isEmpty())
                System.out.print("-1 ");
            else
                System.out.print(stack.peek() + " ");

            // Push current element to stack
            stack.push(arr[i]);
        }
    }


}
