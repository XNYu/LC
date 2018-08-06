package Design;

import DFS.TreeNode;

public class Codec {
    StringBuilder sb = new StringBuilder("");
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        sb.append(root.val);
        String left = serialize(root.left);
        String right = serialize(root.right);
        int ll = left.length();
        int lr = right.length();
        if (ll < lr) {
            for (int i = 0; i < lr-ll; i++) {
                left += "X";
            }
        } else if (lr < ll) {
            for (int i = 0; i < ll-lr; i++) {
                right += "X";
            }
        }
        sb.append(left).append(right);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        return des(data, 0, data.length());
    }

    public TreeNode des(String data, int start, int end) {
        if (start >= end || data.charAt(start) == 'X') {
            return null;
        }
        TreeNode head = new TreeNode(data.charAt(start)-48);
        int right = 1+(data.length() + start)/2;
        head.left = des(data, start + 1,right);
        if(right>start)
            head.right = des(data, right,end);
        return head;
    }
}
