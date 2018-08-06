package dp;

import java.util.*;
public class LC312BurstBallons {
    int[] nums;
    Map<String, Integer> maxMap = new HashMap<>();

    public int maxCoins(int[] nums) {
        this.nums = nums;
        int len = nums.length;
        if(len==0)
            return 0;
        if (len == 1) {
            return nums[0];
        }
        return maxC(nums);
    }

    public String getString(int[] nums){
        String ans = "";
        for (int i = 0; i < nums.length; i++) {
            ans += nums[i];
        }
        return ans;
    }

    public int maxC(int[] list) {
        String listStr = getString(list);
        if(maxMap.containsKey(listStr))
            return maxMap.get(listStr);
        int len = list.length;
        if (len == 1) {
            return list[0];
        }
        int max = -1;
        for (int pos = 0; pos < len; pos++) {
            int coin=0;
            int cur=0;
            if(pos==0)
            {
                coin = list[pos] * list[1];
            }
            else if(pos==len-1)
            {
                coin = list[pos] * list[pos - 1];
            }
            else
                coin = list[pos] * list[pos - 1] * list[pos + 1];
            int[] last = new int[len-1];
            System.arraycopy(list,0,last,0,pos);
            System.arraycopy(list,pos+1,last,pos,len-pos-1);
            cur = coin + maxC(last);
            max = Math.max(max, cur);
        }
        maxMap.put(listStr, max);
        return max;

}

//    public int maxC(List<Integer> list) {
//        String listStr = list.toString();
//        if(maxMap.containsKey(listStr))
//            return maxMap.get(listStr);
//        int len = list.size();
//        if (len == 1) {
//            return list.get(0);
//        }
//        int max = -1;
//        for (int pos = 0; pos < len; pos++) {
//            ArrayList<Integer> backup = new ArrayList<>();
//            backup.addAll(list);
//            int coin=0;
//            int cur=0;
//            if(pos==0)
//            {
//                coin = list.get(pos) * list.get(1);
//            }
//            else if(pos==list.size()-1)
//            {
//                coin = list.get(pos) * list.get(pos - 1);
//            }
//            else
//                coin = list.get(pos) * list.get(pos - 1) * list.get(pos + 1);
//            backup.remove(pos);
//            cur = coin + maxC(backup);
//            max = Math.max(max, cur);
//        }
//        maxMap.put(listStr, max);
//        return max;
//    }

    public static void main(String[] args) {
        LC312BurstBallons l = new LC312BurstBallons();
        int[] nums = new int[]{8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2};
        long cur = System.currentTimeMillis();
        System.out.println(l.maxCoins(nums));
        System.out.println("时间"+(System.currentTimeMillis() - cur));
    }
}
