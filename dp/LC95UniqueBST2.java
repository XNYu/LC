package dp;

import java.util.*;

public class LC95UniqueBST2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public LinkedList<TreeNode>[][] dp;
    public List<TreeNode> generateTrees(int n) {
        dp = new LinkedList[n][n];
        return getNodes(1, n);
    }

    public LinkedList<TreeNode> getNodes(int from, int to){
        LinkedList<TreeNode> answer = new LinkedList<>();
        if (dp[from - 1][to - 1] != null) {
            return dp[from - 1][to - 1];
        } else {
            for(int i=from;i<=to;i++){
//                System.out.println(i);
                LinkedList<TreeNode> left = new LinkedList<>();
                LinkedList<TreeNode> right = new LinkedList<>();
                if(i>from)
                    left =  getNodes(from, i-1);
                else
                    left.add(null);
                if(i<to)
                    right = getNodes(i+1, to);
                else
                    right.add(null);
                for(TreeNode l:left)
                    for(TreeNode r:right)
                    {
                        TreeNode node = new TreeNode(i);
                        node.left = l;
                        node.right = r;
                        answer.add(node);
//                        if(from==1&&to==3){
//                        System.out.println(from+"→"+to);
//                        print(node);
//                        System.out.println();
//                        }
                    }

            }
        }
        dp[from - 1][to - 1] = answer;
//        if(from==1&&to==3)
//        System.out.println(answer.size());
//        System.out.println(answer.size());
        return answer;
    }

    public void print(TreeNode head){
        if(head==null)
        {
            System.out.print("null ");
            return;
        }
        System.out.print(head.val+" ");
        print(head.left);
        print(head.right);
    }

    public static void main(String[] args) {
        LC95UniqueBST2 l = new LC95UniqueBST2();
        LinkedList<TreeNode> list = (LinkedList<TreeNode>) l.generateTrees(3);
        for(TreeNode t:list)
        {
            System.out.println();
            l.print(t);
        }
    }
}
