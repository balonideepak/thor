package stack.leetcode;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    static String  removeDuplicatesApproach1(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    static String  removeDuplicatesUsingStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String str= "abbaca";
        String s = removeDuplicatesApproach1(str);
        System.out.println(s);

        String s1 = removeDuplicatesUsingStack(str);
        System.out.println(s1);

    }
}
