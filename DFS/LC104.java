package DFS;


public class LC104 {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if(root==null)
            return 0;
        return 1 + Math.max(dfs(root.left),dfs(root.right));
    }
}
