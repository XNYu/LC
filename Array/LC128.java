package Array;

import java.util.HashMap;
import java.util.Map;

public class LC128 {
    public int longestConsecutive2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int n : nums) {
            if(!map.containsKey(n)) {
                int left = map.containsKey(n-1) ? map.get(n-1) : 0;
                int right = map.containsKey(n+1) ? map.get(n+1) : 0;
                int sum = 1+left+right;
                map.put(n, sum);
                map.put(n-left, sum);
                map.put(n+right, sum);
                max = Math.max(sum, max);
                System.out.println(map);
            }
        }
        return max;
    }
    HashMap<Integer, Integer> parents = new HashMap<>();
    HashMap<Integer, Integer> size = new HashMap<>();
    public int longestConsecutive(int[] nums) {
        for (int i : nums) {
            if(parents.containsKey(i))
                continue;
            parents.put(i, i);
            size.put(i, 1);
            if (i != Integer.MAX_VALUE && parents.containsKey(i + 1)) {
                union(i,i+1);
            }
            if (i != Integer.MIN_VALUE && parents.containsKey(i - 1)) {
                union(i,i-1);
            }
            System.out.println(parents);
        }
        int max = Integer.MIN_VALUE;
        for (int len : size.values()) {
            max = Math.max(max, len);
        }
        return max;
    }

    public void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);

        if(ra==rb)
            return;
        int sa = size.get(ra);
        int sb = size.get(rb);
        if (a == 4) {
            System.out.println(a+"→"+ra);
            System.out.println(b+"→"+rb);
        }
        if (sa >= sb) {
            parents.put(rb, ra);
            size.put(ra, sa + sb);
        } else {
            parents.put(ra, rb);
            size.put(rb, sa+sb);
        }

    }

    //迭代形式的路径压缩
//    int getf(int v) {
//        int p = v, t;
//        while (f[p] != p) p = f[p];//找到祖先p
//        while (v != p) { t = f[x]; f[x] = p; x = t; } //路径压缩
//        return v;
//    }

    public int find(int i) {
        int backup = i;
        while (parents.get(i) != i) {
            i =parents.get(i);
        }
        while (backup != i) {
            int tmp = parents.get(backup);;
            parents.put(backup, i);
            backup = tmp;
        }
        return i;
    }

    public static void main(String[] args) {
        LC128 l = new LC128();
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(l.longestConsecutive2(nums));
    }


}
