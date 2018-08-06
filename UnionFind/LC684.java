package UnionFind;

public class LC684 {
    public int[] findRedundantConnection(int[][] edges) {
        int[] roots = new int[edges.length+1];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        int[] ans = new int[2];
        for (int[] edge:edges) {
            int pre = edge[0];
            int cur = edge[1];
            int rootP = find(pre, roots);
            int rootC = find(cur, roots);
            System.out.println(pre+","+cur+"   "+rootP+" "+rootC);
            if (rootC == rootP) {
                ans = edge;
                break;
            }
            roots[find(pre, roots)] = find(cur, roots);
        }
        return ans;
    }
    public int find(int num, int[] roots) {
        int r = num;
        while (r != roots[r]) {
            r = roots[r];
        }
        while (num != r) {
            int tmp = roots[num];
            roots[num] = r;
            num = tmp;
        }
        return r;
    }
    public static void main(String[] args) {
        LC684 l = new LC684();
        int[][] edges = new int[][]{{1,2},{1,3},{2,3}};
        int[] ans = l.findRedundantConnection(edges);
        System.out.println(ans[0] + "," + ans[1]);
    }
}
