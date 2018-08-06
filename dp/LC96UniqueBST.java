package dp;

public class LC96UniqueBST {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <=n; i++) {
            int total=0;
            for (int j = 0; j <= (i-1)/2; j++) {
//                System.out.println();
//                if((double)(i-1)/2-j==0)
//                {
//                    System.out.println(j+","+dp[j]+":"+i);
//                    total+=dp[j];
//                }
//                else
                if((double)(i-1)/2-j==0)
                {
                    total+=dp[j]*dp[j];
                }
                else
                    total+=2*dp[i-j-1]*dp[j];
            }
            dp[i] = total;
        }
//        for (int i = 0; i < n+1; i++) {
//            System.out.print(dp[i]+" ");
//        }
        return dp[n];
    }

    public static void main(String[] args) {
        LC96UniqueBST l = new LC96UniqueBST();
        System.out.println(l.numTrees(10));
    }
}
