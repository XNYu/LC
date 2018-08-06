package DFS;

import java.util.*;

public class LC261 {

    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, LinkedList<Integer>> map = new LinkedHashMap<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        for (int[] edge : edges) {
            int pre = edge[0];
            int cur = edge[1];
            int preRoot = findRoot(pre, nums);
            int curRoot = findRoot(cur, nums);
            if(preRoot==curRoot)
                return false;
            else
                nums[curRoot] = preRoot;
        }
        boolean end = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == i) {
                if(end)
                    return false;
                end = true;
            }
        }
        return true;
    }

    public int findRoot(int n, int[] nums) {
        int r = n;
        while (r != nums[r]) {
            r = nums[r];
        }
        int i = n, j;
        while (i != r) {
            j = nums[i];
            nums[i] = r;
            i = j;
        }
        return r;
    }

    public static void main(String[] args) {
        LC261 l = new LC261();
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        System.out.println(l.validTree(5,edges));
    }
}
