import java.util.*;

class FirstNonRepeatingCharacter {

    static String FirstNonRepeating(String A) {
        // Arraylist to keep track of current unique characters
        // Hashmap to keep track of character encountered at least once
        ArrayList<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (char c : A.toCharArray()) {
           if(!map.containsKey(c)){
               map.put(c,1);
               list.add(c);
           }
           else{

               int index = list.indexOf(c);

               // for any repeated character encountered more than twice the
               // index will be -1
               if (index != -1)
                   list.remove(index);


           }

            sb.append(list.isEmpty() ? '#' : list.get(0));
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        String A = "geeksforgeeksandgeeksquizfor";
        String ans = FirstNonRepeating(A);
        System.out.print(ans);
    }
}