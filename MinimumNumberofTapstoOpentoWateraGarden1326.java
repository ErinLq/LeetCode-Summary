package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinimumNumberofTapstoOpentoWateraGarden1326 {
    public static int minTaps(int n, int[] ranges) {
        int[]dp = new int[n + 1];
        Arrays.fill(dp, n + 2);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j= Math.max(0, i - ranges[i] + 1); j <= Math.min(i + ranges[i], n); j++) {
                dp[j] = Math.min(dp[j], dp[Math.max(0, i - ranges[i])] + 1);
            }
        }
        return (dp[n] == n + 2) ? -1 : dp[n];
    }

    public static void main(String[] args) {
        int[] ranges = new int[]{0,0,0,1};

        System.out.println(minTaps(3,ranges));
    }
}
