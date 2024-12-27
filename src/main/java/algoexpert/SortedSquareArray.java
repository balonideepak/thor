package algoexpert;

import java.util.Arrays;

public class SortedSquareArray {

    public static void main(String[] args) {
        int[] result = sortedSquaredArray(new int[]{-7, -3, 1, 9, 22, 30});
        System.out.println(Arrays.toString(result));

    }

    private static int[] sortedSquaredArray(int[] arr) {

        int[] result =new int[arr.length];
        int left=0;
        int right = arr.length-1;
        int smallerValue , largerValue =0;


        for(int i = arr.length-1 ; i>=0 ; i--){
             smallerValue = arr[left];
             largerValue = arr[right];

            if (Math.abs(smallerValue) > Math.abs(largerValue)) {
                result[i] = arr[left] * arr[left] ;
                left++;
            }
            else{
                result[i] = arr[right] * arr[right] ;
                right--;
            }

        }

        return result;

    }
}
