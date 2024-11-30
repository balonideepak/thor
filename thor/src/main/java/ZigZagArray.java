import java.util.Arrays;

public class ZigZagArray {
    public static void main(String[] args) {
        int arr[] = new int[] { 4, 3, 7, 8, 6, 2, 1 };
        zigZag(arr.length,arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void zigZag(int n, int[] arr) {
        // code here

        // Flag true indicates relation "<" is expected,
        // else ">" is expected. The first expected relation
        // is "<"
        boolean flag = true;

        int temp = 0;

        for (int i = 0; i <= arr.length - 2; i++) {
            if (flag) /* "<" relation expected */
            {
                /* If we have a situation like A > B > C,
                we get A > C < B by swapping B and C */
                if (arr[i] > arr[i + 1]) {
                    // swap
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            else /* ">" relation expected */
            {
                /* If we have a situation like A < B < C,
                we get A < C > B by swapping B and C */
                if (arr[i] < arr[i + 1]) {
                    // swap
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            flag = !flag; /* flip flag */
        }


    }
}
