package Array;

public class Helper {
    public void print(Object[][] dp) {
        for (Object[] d : dp) {
            System.out.println();
            for (Object i : d) {
                System.out.print(i+" ");
            }
        }
    }

    public void print(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void print(int[][] nums) {
        for (int[] num : nums) {
            for (int i : num) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
