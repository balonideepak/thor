public class SearchInSortedRotatedArray {

    //https://www.geeksforgeeks.org/problems/search-in-rotated-array-2/1
    //complexity : LogN
    //space : O1
    public static void main(String[] args) {
        int arr[] = {2, 5, 6, 0, 0, 1, 2};
        int k = 0;

        boolean search = search(arr, k);
        System.out.println(search);

    }

    public static boolean search(int[] arr, int k) {

        int low=0;
        int high=arr.length-1;

        return search(arr,low,high,k);


    }

    private static boolean search(int arr[],int low,int high,int key){
        while(low <= high){


            int mid = (low + high )/2;
            if(arr[mid] == key ){
                return true;
            }

            if(arr[low] <= arr[mid]){
                if(key >= arr[low] && key <= arr[mid] ){
                    high = mid-1;
                }else{
                    low=mid+1;
                }

            }
            else{
                if(key >= arr[mid] && key <= arr[high] ){
                    low=mid+1;

                }
                else{
                    high=mid-1;
                }

            }


        }

        return false ;
    }
}
