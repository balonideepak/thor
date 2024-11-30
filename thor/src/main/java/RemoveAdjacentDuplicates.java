import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        String str="acaaabbbacdddd";

        Stack<Character> stack =new Stack<>();
        boolean isPopOperationAllowedForPreviousElem=false;

        for(char c : str.toCharArray()){

            if( !stack.isEmpty() && stack.peek()==c ){
                isPopOperationAllowedForPreviousElem=true;
            }

            if (!stack.isEmpty() && isPopOperationAllowedForPreviousElem){
                stack.pop();
                isPopOperationAllowedForPreviousElem=false;
            }

            if(stack.isEmpty() || stack.peek()!=c){
                stack.push(c);

            }

        }

        String result = stack.stream().map(s -> s.toString()).collect(Collectors.joining(""));
        System.out.println(result);

    }
}
