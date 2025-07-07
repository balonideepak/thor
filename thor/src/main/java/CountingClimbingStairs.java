package work.dp;

public class CountingClimbingStairs {

    public static void main(String[] args) {
        /*
        * You are climbing a staircase. It takes n steps to reach the top.

         Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
        * */

        int n = 3;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] += (i - 1 >= 0) ? dp[i - 1] : 0;
            dp[i] += (i - 2 >= 0) ? dp[i - 2] : 0;
        }

        System.out.println(dp[n]);
    }


    //If allowed steps are variable (e.g., int[] steps = {1, 3, 5}), you can write a fully generic version

    public int climbStairsGeneric(int n, int[] steps) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int step : steps) {
                if (i - step >= 0) {
                    dp[i] += dp[i - step];
                }
            }
        }

        return dp[n];
    }

}
