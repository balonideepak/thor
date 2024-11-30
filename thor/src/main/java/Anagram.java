public class Anagram {
    public static void main(String[] args) {

        String a="listen";
        String b="silent";

        boolean anagram = isAnagram(a, b);
        System.out.println(anagram);

    }

    public static boolean isAnagram(String a, String b) {

        int[] arr=new int[200];
        for(int i=0;i<a.length();i++){
            arr[a.charAt(i)]++;
        }

        for(int i=0;i<b.length();i++){
            arr[b.charAt(i)]--;
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i] > 0){
                return false;
            }
        }

        return true;

    }
}
