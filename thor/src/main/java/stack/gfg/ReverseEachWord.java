package stack.gfg;

import java.util.*;

public class ReverseEachWord {

    public static void main(String[] args) {
        String result = reverseWords("v f gfc");
        System.out.println(result);
    }


    public static String reverseWords(String s) {
        // Code here
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for(String word:words){
            result.append(new StringBuilder(word).reverse()).append(" ");
        }
        return result.toString().trim();
    }
}
