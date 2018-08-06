package Tree;

import DFS.TreeNode;

public class LC450 {
    TreeNode parent, toDel;
    int value;
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parentOfKey = findParent(key, root, root);
        boolean left = false;
        if (parentOfKey.val != key) {
            if (parentOfKey.left != null && parentOfKey.left.val == key) {
                left = true;
            }
        }
        toDel = left ? parentOfKey.left : parentOfKey.right;
        if (toDel.left != null) {
            value = Integer.MIN_VALUE;
            findReplace(toDel.left, toDel, true);
            TreeNode toReplace = null;
            if (parent != toDel) {
                parent.right = null;
                toReplace = new TreeNode(value);
                toReplace.left = toDel.left;
            } else {
                toReplace = toDel.left;
            }
            if (left) {
                parentOfKey.left = toReplace;
            } else {
                parentOfKey.right = toReplace;
            }
        } else if (toDel.right != null) {
            value = Integer.MAX_VALUE;
            findReplace(toDel.right, toDel, false);
            TreeNode toReplace = null;
            if (parent != toDel) {
                parent.left = null;
                toReplace = new TreeNode(value);
                toReplace.right = toDel.right;
            } else {
                toReplace = toDel.right;
            }
            if (left) {
                parentOfKey.left = toReplace;
            } else {
                parentOfKey.right = toReplace;
            }
        } else {
            toDel = null;
        }
        return root;
    }

    public TreeNode findParent(int value, TreeNode root, TreeNode parent) {
        if (root == null) {
            return null;
        }
        if (root.val == value) {
            return parent;
        }
        TreeNode l = findParent(value, root.left, root);
        if(l!=null)
            return l;
        return findParent(value, root.right, root);
    }

    public void findReplace(TreeNode root, TreeNode parent,boolean max) {
        if (root == null) {
            return;
        }
        if (max) {
            if (root.val > value) {
                this.parent = parent;
                value = root.val;
            }
        } else {
            if (root.val < value) {
                this.parent = parent;
                value = root.val;
            }
        }
        findReplace(root.left, root,max);
        findReplace(root.right, root,max);
    }
}
