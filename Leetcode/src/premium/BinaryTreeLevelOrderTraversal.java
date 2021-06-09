package src.premium;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
//https://leetcode.com/problems/binary-tree-vertical-order-traversal/discuss/76401/5ms-Java-Clean-Solution
    public List<List<Integer>> verticalOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        List<List<Integer>> output = new ArrayList<>();

        Map<Integer, List<Integer>> colToList = new HashMap<>();

        if(root == null) return  output;

        queue.add(root);
        cols.add(0);

        int min = 0, max = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int col = cols.poll();

            if(!colToList.containsKey(col))
                colToList.put(col, new ArrayList<>());

            colToList.get(col).add(node.val);

            if(node.left!=null){
                queue.add(node.left);
                cols.add(col-1);
                min = Math.min(min, col-1);
            }

            if(node.right != null){
                queue.add(node.right);
                cols.add(col+1);
                max = Math.max(max, col+1);
            }
        }

        for(int i=min; i <= max; i++){
            output.add(colToList.get(i));
        }
        return output;
    }


}
