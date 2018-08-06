package backtrack;

import java.util.LinkedList;
import java.util.List;

public class LC77 {
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        add(ans,list,1, n, k);
        return ans;
    }

    public void add(List<List<Integer>> ans, LinkedList<Integer> toAdd,int start, int n, int k) {
        if(k==0){
            ans.add(new LinkedList<>(toAdd));
            return;
        }
        for (int i = start; i <= n ; i++) {
            toAdd.add(i);
            add(ans, toAdd, i+1,n,k-1);
            toAdd.removeLast();
        }
    }

    public static void main(String[] args) {
        LC77 l = new LC77();
        System.out.println(l.combine(4,2));
    }

}
