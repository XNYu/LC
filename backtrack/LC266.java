package backtrack;

public class LC266 {
    public boolean canPermutePalindrome(String s) {
        int[] times = new int[123];
        for (int i = 0; i < s.length(); i++) {
            times[s.charAt(i)]+=1;
        }
        int count = 0;
        for (int i = 0; i < times.length; i++) {
            if(times[i]%2==1)
                if (count == 0) {
                    count++;
                } else {
                    return false;
                }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf('z'));
    }
}
