package HashTable;

public class LC204 {
    public int countPrimes(int n) {
        if(n == 0 || n == 1)
            return 0;

        boolean[] isPrime = new boolean[n];
        int count = 0;

        for(int i=2; i<n; i++){
            if(!isPrime[i]){
                count++;
                System.out.println(i);
                for(int j=2; i*j<n; j++){
                    isPrime[i*j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LC204 l = new LC204();
        System.out.println(l.countPrimes(499979));
    }
}
