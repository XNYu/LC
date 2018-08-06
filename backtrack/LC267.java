package backtrack;

import java.util.ArrayList;
import java.util.List;

public class LC267 {
    List<String> ans = new ArrayList<>();
    public List<String> generatePalindromes(String s) {
        int[] times = new int[123];
        for (int i = 0; i < s.length(); i++) {
            times[s.charAt(i)]+=1;
        }
        int count = 0;
        for (int i = 0; i < times.length; i++) {
            if(times[i]%2==1)
                if (count == 0) {
                    count=i;
                } else {
                    return new ArrayList<>();
                }
        }


        return ans;
    }
}
