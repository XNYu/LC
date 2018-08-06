package DFS;

public class LC513 {
    int maxDepth = 0;
    int ans = 0;
    public int findBottomLeftValue(TreeNode root) {
        find(root,1);
        return ans;
    }

    public void find(TreeNode root, int depth) {
        if (root==null)
            return;
        if(maxDepth<depth)
        {
            maxDepth = depth;
            ans = root.val;
        }
        depth++;
        find(root.left, depth);
        find(root.right, depth);
    }
}
