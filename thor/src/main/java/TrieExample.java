import java.util.Arrays;

public class TrieExample {

    private static TrieNode root = new TrieNode();

    public static void main(String[] args) {
        String inputs[] = {"the", "there"};
        for (String input : inputs) {
            insert(input);
        }

        String search = "the";
        System.out.println("Is present: " + search(search));
    }

    private static void insert(String input) {
        input = input.toLowerCase();
        TrieNode trieNode = root;
        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            index = input.charAt(i) - 'a';
            if (trieNode.children[index] == null) {
                trieNode.children[index] = new TrieNode();
            }
            trieNode = trieNode.children[index];
        }
        trieNode.isEndOfWord = true;
    }

    private static boolean search(String input) {
        input = input.toLowerCase();
        TrieNode trieNode = root;
        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            index = input.charAt(i) - 'a';
            if (trieNode.children[index] == null) {
                return false;
            }
            trieNode = trieNode.children[index];
        }

        return true;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;

        public TrieNode() {
            isEndOfWord = false;
        }

        @Override
        public String toString() {
            return Arrays.toString(children);
        }
    }


}
