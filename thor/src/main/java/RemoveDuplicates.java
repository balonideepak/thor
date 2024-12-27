import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {


    public static void main(String[] args) {
        String zvvo = removeDups("zvvo");
        System.out.println(zvvo);
    }
    static String  removeDups(String s) {
        // code here
        Map<Character,Integer> map =new HashMap<>();
        StringBuilder sb =new StringBuilder();
        for (char c : s.toCharArray()){
            if(map.get(c)==null){
                map.put(c,1);
                sb.append(String.valueOf(c));
            }

        }


        return sb.toString();


    }
}
