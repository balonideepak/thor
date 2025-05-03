package stack.gfg;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        ArrayList<Integer> integers = nextLargerElement(arr);
        System.out.println(integers);

    }

    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here

        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i] = -1;
            }else{
                nge[i] = st.peek();
            }
            st.push(arr[i]);
        }
        for(int val : nge){
            ans.add(val);
        }
        return ans;

    }
}
