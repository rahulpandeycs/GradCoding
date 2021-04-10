package src.AmzOA;

import java.util.*;

public class MinDifficulty {

    //Time complexity O(n * nd)  -> Let the length of the array be n i.e number of jobs, in this case we are processing nd states and each one requires n amount of wor to be done.
    // The dfs is being called for d days each doing O(n) amount of work and this is being done 0 -> jobDifficulty length hence
    //Space complexity O(nd)
    // https://www.youtube.com/watch?v=pmQAtRZ3CuE&ab_channel=AslanTashtanov

    public static int minDifficulty2(List<Integer> jobDifficulty, int d) {
        if( d > jobDifficulty.size()) return -1;
        int[][] dp = new int[d+1][jobDifficulty.size()];

        for(int[] p : dp){
            Arrays.fill(p, -1);
        }
        return dfs(jobDifficulty, d, dp,0);
    }

    private static int dfs(List<Integer> jobDifficulty, int d, int[][] dp, int splitIndex){
        if(d == 1) {
            int max = 0;
            while (splitIndex < jobDifficulty.size()) max = Math.max(max, jobDifficulty.get(splitIndex++));
            return max;
        }

        if(dp[d][splitIndex] != -1) return dp[d][splitIndex];
        int max = 0;
        int res = Integer.MAX_VALUE;

        for(int i = splitIndex; i < jobDifficulty.size() - d +1; i++){
            max = Math.max(max, jobDifficulty.get(i));
            res = Math.min(res, max+ dfs(jobDifficulty, d-1, dp, i+1));
        }
        return  dp[d][splitIndex] = res;
    }


    public static int minDifficulty(List<Integer> A, int D) {
        int n = A.size();
        if (n < D) return -1;
        int[] dp = new int[n], dp2 = new int[n], tmp;
        Arrays.fill(dp, 1000);
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for (int d = 0; d < D; ++d) {
            stack.clear();
            for (int i = d; i < n; i++) {
                dp2[i] = i > 0 ? dp[i - 1] + A.get(i) : A.get(i);
                while (!stack.isEmpty() && A.get(stack.peek()) <= A.get(i)) {
                    int j = stack.pop();
                    dp2[i] = Math.min(dp2[i], dp2[j] - A.get(j) + A.get(i));
                }
                if (!stack.isEmpty()) {
                    dp2[i] = Math.min(dp2[i], dp2[stack.peek()]);
                }
                stack.push(i);
            }
            tmp = dp;
            dp = dp2;
            dp2 = tmp;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(minDifficulty2(Arrays.asList(11,111,22,222,33,333,44,444), 6));
    }
}
