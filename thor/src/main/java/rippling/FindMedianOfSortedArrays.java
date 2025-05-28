package work.leetcode.rippling;

import java.util.Arrays;

public class FindMedianOfSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1=nums1.length;
        int n2=nums2.length;

        int[] result = new int[n1+n2];
        System.arraycopy(nums1, 0, result, 0, n1);

        for(int i=n1+1;i<n1+n2;i++){
            result[i]=0;
        }

        merge(result , n1 , nums2 , n2);
        System.out.println(Arrays.toString(result));

        int mid = result.length / 2;
        if(result.length%2!=0){
            return result[mid];
        }
        else{
            return (double) (result[mid - 1] + result[mid]) /2;
        }


    }

    private static void merge(int[] nums1,int m , int[] nums2 , int n){

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }



    }
}
