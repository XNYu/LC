package DFS;

import sun.reflect.generics.tree.Tree;

public class LC98 {
    int min = Integer.MIN_VALUE,  max = Integer.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        int[] left = find(root.left);
        int[] right = find(root.right);
        if(left[0]==1&&right[0]==1&&(left[1]<root.val)&&right[2]>root.val)
            return true;
        return false;
    }

    public int[] find(TreeNode root) {
        if(root==null)
            return new int[]{1, max, min};
        int[] ans = new int[3];
        int[] left = find(root.left);
        int[] right = find(root.right);
        if (left[0] == 1 && right[0] == 1) {
            ans[0] = 1;
            ans[1] = Math.min(Math.min(root.val, left[1]), right[1]);
            ans[2] = Math.max(Math.max(root.val, right[2]), left[2]);
        }
        return ans;
    }

//    public boolean compare(int sum, TreeNode root, boolean bigger) {
//        if(root==null)
//            return true;
//        else if (bigger) {
//            if (sum > root.val) {
//                return true;
//            }
//            return false;
//        } else {
//            if (sum < root.val) {
//                return true;
//            }
//            return false;
//        }
//
//    }
//
//    public boolean go(TreeNode root, boolean goLeft) {
//        if (root == null) {
//            return true;
//        }
//        boolean left = go(root.left,true);
//        boolean right = go(root.right,false);
//        if (left && right) {
//            boolean ans ;
//            if(compare(root.val,root.left,true)&&compare(root.val,root.right,false))
//                ans = true;
//            else
//                ans = false;
//            if (goLeft) {
//                if (root.right != null) {
//                    root.val = root.right.val;
//                }
//            } else {
//                if (root.left != null) {
//                    root.val = root.left.val;
//                }
//            }
//            return ans;
//        }
//        else
//            return false;
//    }


}
