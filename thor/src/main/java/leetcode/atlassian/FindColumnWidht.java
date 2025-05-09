package leetcode.atlassian;

import java.util.Arrays;

public class FindColumnWidht {
    public static void main(String[] args) {
        int[][] grid = {{-15,1,3},{15,7,12},{5,6,-2}};
        int[] columnWidth = findColumnWidth(grid);
        System.out.println(Arrays.toString(columnWidth));

    }

    public static int[] findColumnWidth(int[][] grid) {

        int cols = grid[0].length;
        int rows = grid.length;

        int[] result =new int[cols];

        for(int i=0 ; i< cols ; i++){
            for(int j=0; j<rows ; j++){
                result[i] = Math.max(result[i], digit(grid[j][i]));
            }
        }


        return result;

    }

    private static int digit(int n){
        if (n == 0){
            return 1;
        }
        int ans = 0;
        if (n < 0)
            ans++;
        n = Math.abs(n);
        while (n != 0){
            ans++;
            n /= 10;
        }
        return ans;
    }
}
