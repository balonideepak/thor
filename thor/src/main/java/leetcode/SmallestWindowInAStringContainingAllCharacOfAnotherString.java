package string.atlassian.leetcode;

public class SmallestWindowInAStringContainingAllCharacOfAnotherString {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t)); // Output: "BANC"
    }

    private static boolean minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return false;
        }
        int[] sCount = new int[256];
        int[] tCount = new int[256];
        for (char c : t.toCharArray()) {
            tCount[c]++;
        }
        int start = 0, end = 0, minLength = Integer.MAX_VALUE, minStart = 0;
        int count = 0;
        while (end < s.length()) {
            char endChar = s.charAt(end);
            sCount[endChar]++;
            if (sCount[endChar] <= tCount[endChar]) {
                count++;
            }
            while (count == t.length()) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    minStart = start;
                }
                char startChar = s.charAt(start);
                sCount[startChar]--;
                if (sCount[startChar] < tCount[startChar]) {
                    count--;
                }
                start++;
            }
            end++;
        }
        if (minLength != Integer.MAX_VALUE) {
            System.out.println("Smallest window: " + s.substring(minStart, minStart + minLength));
            return true;
        }
        System.out.println("No such window exists");

        return false;
    }
}
