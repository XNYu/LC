package Array;

public class LC670 {
    public int maximumSwap(int num) {
        String n = String.valueOf(num);
        char[] cs = n.toCharArray();
        int from=0,to=0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < cs.length-1; i++) {
            int pre = cs[i];
            from = i;
            boolean found = false;
            for (int j = i+1; j < cs.length; j++) {
                int cur = cs[j];
                System.out.println(cur+","+pre);
                if(cur>pre)
                {
                    found = true;
                    if (cur > max) {
                        max = cur;
                        to = j;
                    }
                }
            }
            if(found)
                break;
        }
        char tmp = cs[from];
        cs[from] = cs[to];
        cs[to] = tmp;
        return Integer.valueOf(String.valueOf(cs));
    }

    public static void main(String[] args) {
        LC670 l = new LC670();
        System.out.println(l.maximumSwap(2698));
    }
}
