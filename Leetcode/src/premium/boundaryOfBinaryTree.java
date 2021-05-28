package src.premium;
import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}

public class boundaryOfBinaryTree {

    List<Integer> boundary = new ArrayList<>();

    public List<Integer> getBoundary(TreeNode root){

        if(root == null) return boundary;

        boundary.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        return boundary;
    }

    void leftBoundary(TreeNode root){
        if(root == null || (root.left ==null && root.right == null)) return;
        boundary.add(root.val);
        if(root.left == null) leftBoundary(root.right);
        else leftBoundary(root.left);
    }

    void rightBoundary(TreeNode root){
        if(root == null || (root.left ==null && root.right == null)) return;
        if(root.right == null) rightBoundary(root.left);
        else rightBoundary(root.right);
        boundary.add(root.val);
    }

    void leaves(TreeNode root){
        if(root == null) return;
        if(root != null && root.left ==null && root.right == null){
            boundary.add(root.val);
            return;
        }

        leaves(root.left);
        leaves(root.right);
    }

}
