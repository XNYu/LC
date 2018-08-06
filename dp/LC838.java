package dp;

import java.util.Arrays;

public class LC838 {
    public String pushDominoes(String dominoes) {
        int len = dominoes.length();
        int[] left = new int[len];
        int[] right = new int[len];
        char[] str = dominoes.toCharArray();

        int force = len;
        for (int i = 0; i < len; i++) {
            char c = str[i];
            if (c == 'R') {

            }
        }
        return "";
    }

    public static void main(String[] args) {
        LC838 l = new LC838();
        System.out.println(l.pushDominoes(".L.R...LR..L.."));
    }
}
