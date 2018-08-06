package dp;

import java.util.Arrays;
import java.util.LinkedList;

public class LC179LargestNumber {
    class Number implements Comparable<Number>{
        public Number(int value) {
            this.value = value;
        }

        public int value;

        public int compareTo(Number number) {
            int comValue = number.value;
            int len1 = getLen(value);
            int len2 = getLen(comValue);
            int totalLen = len1 + len2;
            long total1 = (long) Math.pow(10, len2) * value + comValue;
            long total2 = (long) Math.pow(10, len1) * comValue + value;
            if(total1<total2)
                return 1;
            if(total1>total2)
                return -1;
            else
                return 0;
        }

        public int getLen(int num){
            String str = "" + num;
            return str.length();
        }
    }

    public String largestNumber(int[] nums) {
        Number[] numbers = new Number[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Number n = new Number(nums[i]);
            numbers[i] = n;
        }
        Arrays.sort(numbers);
        String str = "";
        for (int i = 0; i < numbers.length; i++) {
            str+=numbers[i].value;
        }
        if (str.startsWith("0"))
            return "0";
        return str;
    }

    public static void main(String[] args) {
        LC179LargestNumber l = new LC179LargestNumber();
        int[] num = new int[]{999999998,999999997,999999999};
        System.out.println(l.largestNumber(num));
    }


}
