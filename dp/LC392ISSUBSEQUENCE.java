package dp;

public class LC392ISSUBSEQUENCE {
    public boolean isSubsequence(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        int pos = 0, pot = 0;
        boolean found = false;
        while (!found&&pos<lens&&pot<lent){
            char ss = s.charAt(pos);
            char tt = t.charAt(pot);
            if(ss==tt)
            {
                if(pos==lens-1)
                    found = true;
                pos++;
                pot++;
            }
            else {
                pot++;
            }
        }
        return found;
    }
}
