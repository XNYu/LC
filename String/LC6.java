package String;

import java.util.Arrays;

public class LC6 {
    public String convert(String s, int numRows){
        int len = s.length();
        if(numRows<2)
            return s;
        int number = 2 * (numRows - 1);
        StringBuilder[] strs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            strs[i] = new StringBuilder();
        }
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int mod = i % number;
            if(mod>=numRows)
                mod = number - mod;
            strs[mod].append(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            stringBuilder.append(strs[i]);
        }
        return stringBuilder.toString();
    }

    public String convert2(String s, int numRows) {
        int len = s.length();
        int width = len / 2 + 1;
        char[][] zig = new char[numRows][width];
        for (int i = 0; i < numRows; i++) {
            Arrays.fill(zig[i],'0');
        }
        int i = 0;
        int hi = 0;
        int wi = 0;
        String ans = "";
        boolean vertical = true, horizon = false;
        while (i < len) {
            char c = s.charAt(i);
            zig[hi][wi] = c;
            i++;
            if (vertical) {
                hi++;
                if(hi==numRows-1)
                    vertical = false;
            }
            else{
                hi--;
                wi++;
                if(hi==0)
                    vertical = true;
            }
        }
        for (int j = 0; j < numRows; j++) {
            System.out.println();
            for (int k = 0; k < width; k++) {
                char c = zig[j][k];
                if(c!='0')
                {
                    ans += c;
                    System.out.print(c+" ");
                }
                else
                    System.out.print("  ");
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC6 l = new LC6();
        System.out.println(l.convert("PAYPALISHIRING", 4));
    }

}
