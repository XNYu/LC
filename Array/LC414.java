package Array;

public class LC414 {
    public int thirdMax(int[] nums) {
        long m1,m2,m3;
        m1=m2=m3=Long.MIN_VALUE;
        for(int i:nums){
            System.out.println(m1+","+m2+","+m3);
            if(i>m1){
                m3 = m2;
                m2 = m1;
                m1 =i;
            }
            else if(i<m1&&i>m2){
                m3 = m2;
                m2 = i;
            }
            else if(i<m2&&i>m3){
                m3 = i;
            }
        }

        if(m3!=Long.MIN_VALUE)
            return (int)m3;
        return (int)m1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,1};
        LC414 l = new LC414();
        System.out.println(l.thirdMax(nums));
    }
}
