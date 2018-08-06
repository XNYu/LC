package DFS;

public class LC437 {
    int ori = 0;
    public int pathSum(TreeNode root, int sum) {
        ori = sum;
        return path1(root, sum);
    }

    public int path(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int total = 0;
        if(root.val==sum)
            total += 1;
        total += path(root.left, sum) + path(root.right, sum);
        return total;
    }

    public int path1(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int total = 0;
        System.out.println(root.val+","+sum);
        if(root.val==sum)
        {total+= 1;System.out.println("Found " +root.val);}
        total += path1(root.left, sum- root.val) + path1(root.right, sum- root.val);
        return total;
    }
}
