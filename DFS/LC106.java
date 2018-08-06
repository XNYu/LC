package DFS;

import java.util.*;

public class LC106 {
    ArrayList<Integer> in,post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in = new ArrayList<>();
        for (int i : inorder) {
            in.add(i);
        }
        post = new ArrayList<>();
        for (int i : postorder) {
            post.add(i);
        }
        return find(0, in.size()-1,0,in.size()-1);
    }

    public TreeNode find(int si, int ei, int sp, int ep) {
        if(si>ei)
            return null;
        int i=0;
        int rootVal = post.get(ep);
        int rootIndex = in.indexOf(rootVal);
        TreeNode root = new TreeNode(rootVal);
        if (si == ei) {
            return root;
        }
//        System.out.println(rootVal);
//        System.out.println(si+","+rootIndex);
        int rightLen = ei - rootIndex;
        root.left = find(si, rootIndex - 1, sp, ep-1-rightLen);
        root.right = find(rootIndex + 1, ei, ep-1-rightLen, ep-1);
        return root;
    }

    public static void main(String[] args) {
        LC106 l = new LC106();
        int[] in = new int[]{9,3,15,20,7};
        int[] pre = new int[]{9,15,7,20,3};
        TreeNode t = l.buildTree(in, pre);
        System.out.println(t.val);
        System.out.println(t.left.val);
        System.out.println(t.right.val);
        System.out.println(t.right.left.val);
    }
}
