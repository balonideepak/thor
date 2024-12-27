import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class FourNumberSum {

    public static void main(String[] args) {
        int[] arr = {7, 6, 4, -1, 1, 2};
        int target = 16;

        fourNumberSum(arr, target);
    }

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        // Write your code here.

        return findFourElements(array, array.length, targetSum);
    }


    static class pair {
        int first, second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // The function finds four elements
    // with given sum X
    static List<Integer[]> findFourElements(int arr[], int n, int X) {

        List<Integer[]> result = new ArrayList<>();
        // Store sums of all pairs in a hash table
        HashMap<Integer, pair> mp
                = new HashMap<Integer, pair>();

        int[] temp = new int[arr.length];
        for (int i = 0; i < temp.length; i++)
            temp[i] = 0;

        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                mp.put(arr[i] + arr[j], new pair(i, j));


        int counter=0;

        // Traverse through all pairs and search
        // for X - (current pair sum).
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];

                // If X - sum is present in hash table,
                if (mp.containsKey(X - sum)) {

                    // Making sure that all elements are
                    // distinct array elements and an
                    // element is not considered more than
                    // once.
                    pair p = mp.get(X - sum);
                    if (p.first != i && p.first != j
                            && p.second != i && p.second != j
                            && temp[p.first] == 0
                            && temp[p.second] == 0
                            && temp[i] == 0
                            && temp[j] == 0) {
                        result.add(counter,new Integer[]{arr[i], arr[j], arr[p.first], arr[p.second]});
                        temp[p.first] = 1;
                        temp[p.second] = 1;
                        temp[i] = 1;
                        temp[j] = 1;
                        counter++;
                    }
                }
            }
        }
        for (Integer[] res : result) {
            System.out.println(Arrays.toString(res));
        }

        return result;
    }
}
