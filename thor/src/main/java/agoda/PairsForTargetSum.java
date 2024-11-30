package agoda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairsForTargetSum {

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int target = 6;
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();

        // Initialize pointers
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {

            // Avoiding duplicates
            if (l > 0 && arr[l] == arr[l - 1]) {
                l++;
                continue;
            }

            if (r < arr.length - 1 && arr[r] == arr[r + 1]) {
                r--;
                continue;
            }

            // Check if sum equals the target
            if (arr[l] + arr[r] == target) {
                res.add(Arrays.asList(arr[l], arr[r]));
                l++;
                r--;
            }
            else if (arr[l] + arr[r] > target) {
                r--;
            }
            else {
                l++;
            }
        }


        for (List<Integer> pair : res) {
            System.out.println(pair.get(0) + " " + pair.get(1));
        }

    }
}
