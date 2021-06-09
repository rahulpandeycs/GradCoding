package src.premium;

public class MaximumAverageSubtree {
    double res = Integer.MIN_VALUE;

    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] l = dfs(root.left), r = dfs(root.right);
        int sum = l[0] + r[0] + root.val, count = l[1] + r[1] + 1;
        res = Math.max(1.0 * sum / count, res);
        return new int[] {sum, count};
    }
}
