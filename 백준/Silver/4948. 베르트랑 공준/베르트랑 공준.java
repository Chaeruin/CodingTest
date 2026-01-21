import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = 0;
        while ((input = Integer.parseInt(br.readLine())) != 0 ) {
            System.out.println(countPrime(input));
        }
    }

    static int countPrime(int n) {
        int count = 0;
        for (int i = n + 1; i <= 2 * n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    static boolean isPrime(int n) {
        if (n == 1) return false;
        for (int j = 2; j <= Math.sqrt(n); j++) {
            if (n % j == 0) return false;
        }
        return true;
    }
}
