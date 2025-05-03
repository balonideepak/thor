package stack.leetcode;

public class ReversePrefixOfWord {

    /*Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the
    index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.

    For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive).
    The resulting string will be "dcbaefd".
    Return the resulting string.*/

    public static String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }
        return new StringBuilder(word.substring(0, index + 1)).reverse() + word.substring(index + 1);
    }
    public static void main(String[] args) {
        String word ="abcdefz";
        char ch = 'd';
        String s = reversePrefix(word, ch);
        System.out.println(s);
    }
}
