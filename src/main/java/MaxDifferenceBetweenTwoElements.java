
public class MaxDifferenceBetweenTwoElements {


    public static void main(String[] args) {
        int arr[] ={7,9,5,6,3,2};
        int result = maxDiff(arr);
        System.out.println(result);

    }

    private static int maxDiff(int[] arr){
        int max_diff=arr[1]-arr[0];
        int min_val=arr[0];

        for(int i=1;i<arr.length;i++){
            if(arr[i]-min_val > max_diff){
                max_diff=arr[i]-min_val;
            }

            if(arr[i] < min_val){
                min_val=arr[i];
            }
        }

        return max_diff;

    }
}
