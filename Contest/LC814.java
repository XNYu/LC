package Contest;

import DFS.TreeNode;

public class LC814 {
    public TreeNode pruneTree(TreeNode root) {
        pruneTree(root.left);
        pruneTree(root.right);
        if(!hasOne(root.left))
            root.left = null;
        if(!hasOne(root.right))
            root.right = null;
        if(!hasOne(root))
            return null;
        return root;
    }

    public boolean hasOne(TreeNode root) {
        if(root==null)
            return false;
        if(root.val==1)
            return true;
        else
            return hasOne(root.left) || hasOne(root.right);
    }


}
