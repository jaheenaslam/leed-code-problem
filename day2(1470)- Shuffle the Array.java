class Solution {
    public int numOfArrays(int n, int m, int k) {
        if (k == 0) return 0;
        long[][][] dp = new long[n + 1][m + 1][k + 1];
        int MOD = 1_000_000_007;
        for (int j = 1; j <= m; j++) {
            dp[1][j][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int c = 1; c <= k; c++) {
                    long count = (dp[i - 1][j][c] * j) % MOD;
                    for (int prev = 1; prev < j; prev++) {
                        count = (count + dp[i - 1][prev][c - 1]) % MOD;
                    }

                    dp[i][j][c] = count;
                }
            }
        }
        long totalWays = 0;
        for (int j = 1; j <= m; j++) {
            totalWays = (totalWays + dp[n][j][k]) % MOD;
        }

        return (int) totalWays;
    }
}
