package Contest;

public class LC812 {
    public double largestTriangleArea(int[][] points) {
        int len = points.length;
        double max = 0;
        for (int i = 0; i < len; i++) {
            int[] p1 = points[i];
            for (int j = i+1; j < len; j++) {
                int[] p2 = points[j];
                for (int k = j+1; k < len; k++) {
                    int[] p0 = points[k];
                    max = Math.max(cal(p1, p2, p0),max);
                }
            }
        }
        return max;
    }

    public double cal(int[] p1,int[] p2,int[] p0) {
        int ax = p0[0] - p1[0];
        int ay = p0[1] - p1[1];
        int bx = p0[0] - p2[0];
        int by = p0[1] - p2[1];
        double ans =  Math.abs(ax * by - ay * bx);
        System.out.println(ans);
        return ans/2;
    }

    public static void main(String[] args) {
        LC812 l = new LC812();
        System.out.println(l.largestTriangleArea(new int[][]{{1,0},{0,0},{0,1}}));
    }
}
