package dp;

public class LC647PalindromicSubstrings {
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        dp = new int[len][len];
        int ans =0;
//        for (int i = 0; i < len; i++) {
//            System.out.println("i="+i);
//            ans =Math.max(Math.max(count(s,i,i+1,0), count(s, i, i,0)),ans);
//        }
        ans = count(s, 0, len-1);
        return ans;
    }

    public int count(String s, int start, int end){
        int max = 0;
        if(start<0||end>=s.length()||start>end)
        {
            return max;
        }
        if(dp[start][end]!=0)
        {
            return dp[start][end];

        }
        if(s.charAt(start)==s.charAt(end))
        {
            if(start==end)
            {
                max+=1;
//                System.out.println(start + "," + end + s.charAt(start));
            }
            else
            {
                max+=2;
//                System.out.println(start + "," + end + " total 2");
            }
            max = max + count(s, start+1, end-1);
        }
        else
        {
//            System.out.println("Go for it");
//            System.out.println(start+","+end+" total "+total);
            int one = count(s, start+1, end);
//            System.out.println("one "+one);
            int two = count(s, start, end-1);
//            System.out.println("two " + two);
            max = max + Math.max(two, one);
        }
        dp[start][end] = max;
        return max;
    }

    public static void main(String[] args) {
        LC647PalindromicSubstrings l = new LC647PalindromicSubstrings();
        System.out.println(l.longestPalindromeSubseq("bbbbbbbbbbcccccccccccccccccccbbabbbbbbbbbbb"));
    }
}
