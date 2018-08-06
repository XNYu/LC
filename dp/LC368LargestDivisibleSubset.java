package dp;

import java.util.*;

public class LC368LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        int[] record = new int[len];
        int[] length = new int[len];
        Arrays.fill(record,-1);
        LinkedList<Integer> list = new LinkedList<>();
        if(len==0)
            return list;
        if(len==1)
        {
            list.add(nums[0]);
            return list;
        }
        Arrays.sort(nums);
//        print(nums);
        length[len-1]=0;
        int max = 0;
        int start=0;
        for (int i = len-2; i >=0 ; i--) {
            int curLen = 0;
            int pre = nums[i];
            for (int j = i+1; j < len; j++) {
                int end = nums[j];
                if(end%pre==0){
                    int newLen = length[j]+1;
                    if (newLen > curLen) {
                        record[i] = j;
                        curLen = newLen;
                    }
                }
            }
            length[i] = curLen;
            if(curLen>max){
                max = curLen;
                start = i;
            }
        }

        list.add(nums[start]);
        while (record[start]!=-1)
        {
            start = record[start];
            list.add(nums[start]);
        }
//        print(length);
        return list;
    }

    public void print(int[] nums) {
        for (int i = 0; i <nums.length ; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
    public void print(List<Integer> i){
        for (int num:i){
            System.out.print(num+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LC368LargestDivisibleSubset l = new LC368LargestDivisibleSubset();
        int[] nums = new int[]{2,3,4,9,8};
        l.print(l.largestDivisibleSubset(nums));

    }
}
