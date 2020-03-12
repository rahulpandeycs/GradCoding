public class KnapsackProblem {


  public static void main(String[] args) {
    int[] val = new int[]{60, 100, 120};
    int[] wt = new int[]{10, 20, 30};
    int W = 50;
    int n = val.length;
    System.out.println("Without DP: " + knapSack(W, wt, val, n));
    System.out.println("With DP: " + knapSackDP(W, wt, val, n));
  }

  static int knapSack(int W, int[] wt, int[] val, int n) {
    if (W == 0 || n == 0)
      return 0;

    if (wt[n - 1] > W)
      return knapSack(W, wt, val, n - 1);
    else
      return Math.max(knapSack(W - wt[n - 1], wt, val, n - 1) + val[n - 1], knapSack(W, wt, val, n - 1));
  }

  static int knapSackDP(int W, int[] wt, int[] val, int n) {
    int[][] dp = new int[n + 1][W + 1];

    for (int k = 0; k <= n; k++) {
      for (int m = 0; m <= W; m++) {
        if (k == 0 || m == 0)
          dp[k][m] = 0;
        else if (wt[k - 1] <= m) {
          dp[k][m] = Math.max(dp[k - 1][m - wt[k - 1]] + val[k - 1], dp[k - 1][m]);
        } else
          dp[k][m] = dp[k - 1][m];
      }
    }
    return dp[n][W];
  }
}
