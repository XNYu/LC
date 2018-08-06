package HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 10) {
            return res;
        }
        char[] map = new char[255];
        map['A'] = 0;
        map['C'] = 1;
        map['G'] = 2;
        map['T'] = 3;
        int mask = 0xfffff;//20bit,10个字母，每个字母占2bit
        int val = 0;
        char[] schar = s.toCharArray();
        for (int i = 0; i < 9; i++) {
            val = (val << 2) | (map[schar[i]] & 3);
        }
        byte[] record = new byte[1 << 20];
        for (int i = 9; i < schar.length; i++) {
            //&mask为了把超出范围的val置零
            // | map[schar[i]] & 3 是给val最后加上新的字母
            val = ((val << 2) & mask) | (map[schar[i]] & 3);
            if (record[val] == 1) {
                res.add(s.substring(i-9, i+1));
            }
            if (record[val] < 2) {
                record[val] ++;
            }
        }
        return res;
    }
    public List<String> findRepeatedDnaSequences2(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> ans = new HashSet<>();
        int start = 0;
        while (start < s.length() - 9) {
            String subS = s.substring(start, start + 10);
            if (!set.add(subS)) {
                ans.add(subS);
            }
            start++;
        }
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        LC187 l = new LC187();
        System.out.println(l.findRepeatedDnaSequences("AAAAAAAAAAAAAA"));
    }
}
