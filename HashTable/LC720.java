package HashTable;

import java.util.ArrayList;

public class LC720 {
    public String longestWord(String[] words) {
        int max = 1;
        String ans = "";
        ArrayList<String> list = new ArrayList<>();
        list.add(ans);
        for (String s : words) {
            System.out.println(s);
            list.add(s);
            if(s.length()>max+1)
                break;
            if (list.contains(s.substring(0, s.length() - 1))) {
                max = s.length();
                ans = s;
            }
        }
        return ans;
    }
}
