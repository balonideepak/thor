package leetcode.atlassian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWordsThatCanBeMadeFromCharacters {

    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        int result = countCharacters(words, chars);
        System.out.println(result);

    }

    public static int countCharacters(String[] words, String chars) {

        Map<Character, Integer> map = new HashMap<>();

        List<String> log = new ArrayList<>();

        for (char c : chars.toCharArray()) {
            map.put(c, 1 + map.getOrDefault(c, 0));
        }

        int res = 0;

        for (String word : words) {

            Map<Character, Integer> copy = new HashMap<>(map);
            boolean found = true;

            for (char c : word.toCharArray()) {
                if (copy.containsKey(c) && copy.get(c) != 0) {
                    copy.put(c, copy.get(c) - 1);
                } else {
                    res -= word.length();
                    found = false;
                    break;
                }
            }

            res += word.length();
            if (found) {
                log.add(word);
            }

        }

        System.out.println(log);
        return res;
    }
}
