package src;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

     TreeNode(int val){
         this.val = val;
     }
}

public class SubtreeWitSum {
    static boolean flagFound = false;
    static boolean subtreeWithSum(TreeNode root, int sum){
        if (root == null) return false;
        rootedSubtreeSum(root, sum);
        return flagFound;
    }

    static int rootedSubtreeSum(TreeNode root,int sum){

        if(root == null) return 0;

        int left = rootedSubtreeSum(root.left,sum);
        int right = rootedSubtreeSum(root.right,sum);
        if(left+right+root.val == sum)
            flagFound = true;
        return (left+right+root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(12);
        root.left.right.right.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.right.right.left = new TreeNode(3);
        int sum = 22;

        if (subtreeWithSum(root, sum))
            System.out.println( "Yes");
        else
            System.out.println( "No");
    }
}
