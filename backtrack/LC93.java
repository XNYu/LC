package backtrack;

import java.util.ArrayList;
import java.util.List;

public class LC93 {
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        back(s, 3, 0);
        return ans;
    }

    public void back(String s, int parts, int start) {
        if(parts==0)
        {
            String lastOne = s.substring(start, s.length());
            if(isValid(lastOne))
                ans.add(s);
            return;
        }
        parts -= 1;
        for (int i = start+1; i < start+4 && i<s.length(); i++) {
            String pre = s.substring(0, start);
            String sub = s.substring(start, i);
            String follow = s.substring(i, s.length());
            if(!isValid(sub))
                continue;
            String fin = pre + sub+ "." + follow;
            back(fin, parts, i+1);
        }
    }
    public boolean isValid(String s) {
        if(s.length()>3||s.length()==0||(s.startsWith("0")&&s.length()>1)||Integer.parseInt(s)>255)
            return false;
        return true;
    }



    public static void main(String[] args) {
        LC93 l = new LC93();
        String test = "010010";
        System.out.println(l.restoreIpAddresses(test));
    }

}
