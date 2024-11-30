public class StringRotatedBy2Places {
    public static void main(String[] args) {
        String str1 = "geeksforgeeks";
        String str2  = "geeksgeeksfor";

        String s1=rotateClockWise(str1);
        String s2=rotateAntiClockWise(str1);

        boolean b = str2.equals(s1) || str2.equals(s2);
        System.out.println(b);


    }

    private static String rotateClockWise(String str){
        return str.substring(str.length()-2,str.length()) +
                str.substring(0,str.length()-2)  ;
    }

    private static String rotateAntiClockWise(String str){
        return str.substring(2,str.length()) +
                str.substring(0,2);
    }
}
