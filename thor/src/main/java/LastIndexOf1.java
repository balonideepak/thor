public class LastIndexOf1 {
    public static void main(String[] args) {
        String s="00001";
        int length = s.length();
        for(int i=length-1 ; i>=0 ; i--){
            if(s.charAt(i)==49){
                System.out.println(i);
            }
        }

    }
}
