public class Helper {
    public void print(Object[][] dp) {
        for (Object[] d : dp) {
            System.out.println();
            for (Object i : d) {
                System.out.print(i+" ");
            }
        }
    }
}
