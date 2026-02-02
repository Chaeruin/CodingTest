
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int countRecursion = 0;
    static int countDp = 0;
    static int[] fib;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        fib = new int[n + 1];

        fibRecursion(n);

        fibDp(n);

        System.out.println(countRecursion + " " + countDp);
    }

    static int fibRecursion(int n) {
        if (n == 1 || n == 2) {
            countRecursion++;
            return 1;
        }
        else {
            return fibRecursion(n - 1) + fibRecursion(n - 2);
        }
    }

    static int fibDp(int n) {
        fib[1] = fib[2] = 1;
        for (int i = 3; i <= n; i++) {
            countDp++;
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}
