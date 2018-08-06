package DFS;

public class LC111 {
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        min(root);
        return min;
    }
    public int min(TreeNode root) {
        if(root==null)
            return 0;
        int total =  1 + Math.min(minDepth(root.left),minDepth(root.right));

        min = Math.min(total, min);
        return total;
    }



}
