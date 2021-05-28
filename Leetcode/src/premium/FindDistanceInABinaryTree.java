package src.premium;

//https://leetcode.com/problems/find-distance-in-a-binary-tree/discuss/1039737/Detailed-explanation-of-how-to-solve-in-ONE-pass-based-on-LCA-approach
//https://leetcode.com/problems/find-distance-in-a-binary-tree/
public class FindDistanceInABinaryTree {

    public int findDistance(TreeNode root, int p, int q) {
        if (root == null) return 0;
        if (p == q) {
            return 0;
        }
        return dfs(root, p, q, 0);
    }

    int dfs(TreeNode root, int p, int q, int depth) {

        int retDepth = depth;
        if (root == null) {
            retDepth = 0;
        } else if (root.val == p || root.val == q) {
            int left = dfs(root.left, p, q, 1);
            int right = dfs(root.right, p, q, 1);

            if (left > 0 || right > 0) {
                retDepth = left > 0 ? left : right; // we know that current node is one of interested node, so only left or right could have a positive value.
                // case 1: If either of them is positive, current node is indeed least common ancestor. So, distance is depth of the child node from current node
                // case 2: If the other node did not fall into the descendants of current node, return current depth
            }
        } else {
            int left = dfs(root.left, p, q, depth + 1);
            int right = dfs(root.right, p, q, depth + 1);

            retDepth = left + right;

            if (left != 0 && right != 0) {
                retDepth -= 2 * depth; // // if both left child and right child are non-zero => current node is least common ancestor
                // so, distance between node = (distance of left from here + distance of right from here)
                // but we calculated the depth of left and right from root. So, remove the excess distance
                // i.e., we calculated distance from root to current node twice unnecessarily. So, remove this from the sum
            }
        }
        return retDepth;
    }
}
