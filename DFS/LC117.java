package DFS;

public class LC117 {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        TreeLinkNode leftMost = root.left != null ? root.left : root.right;
        while (leftMost!=null)
        {
            if(root==leftMost)
                leftMost = getLeftMost(root);
            if (root.left != null) {
                if(root.right!=null)
                    root.left.next = root.right;
                else
                    root.left.next = getLeftMost(root.next);
            }
            if (root.right != null) {
                root.right.next = getLeftMost(root.next);
            }
            root = root.next;
            if(root==null){
                root = leftMost;
            }
        }
}

    public TreeLinkNode getLeftMost(TreeLinkNode root) {
        if(root==null)
            return null;
        if (root.left!=null) {
            return root.left;
        }
        else if(root.right!=null)
            return root.right;
        return getLeftMost(root.next);
    }

    public void c(TreeLinkNode root) {
        if(root==null||isLeaf(root))
            return;
        if (root.right != null) {
            if(root.left!=null)
            {
                root.left.next = root.right;
            }
            TreeLinkNode temp = root;
            link(root.right,temp);
            c(root.right);
        } else if (root.left != null) {
            TreeLinkNode temp = root;
            link(root.left,temp);

        }
        c(root.right);
        c(root.left);
    }

    public void link(TreeLinkNode root, TreeLinkNode temp) {
        while (temp.next != null && isLeaf(temp.next)) {
            temp = temp.next;
        }
        if (temp.next==null||isLeaf(temp.next))
            root.next = null;
        else
            root.next = temp.next.left != null ? temp.next.left : temp.next.right;
    }

    public boolean isLeaf(TreeLinkNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
}
