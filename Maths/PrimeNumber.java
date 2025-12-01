public class Main {

    static boolean isPrime(int N) {
        if (N == 1) return false;
        
        int sq = (int)Math.sqrt(N);
        for (int i = 2; i <= sq; i++) {
            if (N % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(isPrime(7));   // true
        System.out.println(isPrime(10));  // false
    }
}
