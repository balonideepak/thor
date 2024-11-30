import java.util.Arrays;

public class LongestCommonPrefix {

    //https://www.youtube.com/watch?v=wtOQaovlvhY&ab_channel=NikhilLohia

    public static void main(String[] args) {
        String[] strs = {"rn", "an", "nmkhjqc", "h", "wsttodxva"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);


        int[] intArr = {3, 8, 10, 13};
        int k=3;
        int count =0;
        for(int a : intArr){

            int numberOfGroups=a/k;
            int remainder=a%k > 0 ? 1 : 0;

            count = numberOfGroups + remainder + count ;
        }
        System.out.println(count);
    }

    public static String longestCommonPrefix(String arr[]) {
        // code here

        Arrays.sort(arr);

        StringBuilder result = new StringBuilder();

        char[] first = arr[0].toCharArray();
        char[] last = arr[arr.length - 1].toCharArray();

        for (int i = 0; i < first.length; i++) {
            if (first[i] != last[i])
                break;
            result.append(first[i]);
        }

        return result.length()==0? "-1" : result.toString();

    }
}