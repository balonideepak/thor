class RotateArray {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n; // Handle cases where k >= n

        // Reverse entire array
        reverse(nums, 0, n - 1);
        // Reverse first k elements
        reverse(nums, 0, k - 1);
        // Reverse the rest
        reverse(nums, k, n - 1);

    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

}
