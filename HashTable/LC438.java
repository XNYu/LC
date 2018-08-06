package HashTable;

import java.util.ArrayList;
import java.util.List;

public class LC438 {
    public List<Integer> findAnagrams(String s, String p) {

        int[] cur = new int[123];
        int[] pre = new int[123];
        char[] cp = p.toCharArray();
        List<Integer> ans = new ArrayList<>();
        if(s.length()==0||p.length()>s.length())
            return ans;
        for (int i = 0; i < p.length(); i++) {
            cur[s.charAt(i)] += 1;
            pre[p.charAt(i)] += 1;
        }
        for (int i = 0; i <= s.length()-p.length(); i++) {
            if (i > 0) {
                cur[s.charAt(i - 1)] -= 1;
                cur[s.charAt(i - 1 + p.length())] += 1;
            }
            boolean found = true;
            for (char c : cp) {
                if (cur[c] != pre[c]) {
                    found = false;
                }
            }
            if(found)
                ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        LC438 l = new LC438();
        System.out.println(l.findAnagrams("aa","aaa"));
    }
}
