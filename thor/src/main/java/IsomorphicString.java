import java.util.LinkedHashMap;

public class IsomorphicString {


    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {

        LinkedHashMap<Character, Character> sToT = new LinkedHashMap<>();
        LinkedHashMap<Character, Character> tToS = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sToT.containsKey(sChar)) {
                if (sToT.get(sChar) != tChar) return false;
            } else {
                if (tToS.containsKey(tChar)) return false;
                sToT.put(sChar, tChar);
                tToS.put(tChar, sChar);
            }
        }

        return true;
    }
}
