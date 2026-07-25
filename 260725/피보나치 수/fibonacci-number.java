import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[46];
        dp[1] = 1;
        dp[2] = 1;

        fibo(N);

        System.out.println(dp[N]);
    }

    public static void fibo(int n) {
        if (n == 1 || n == 2) return;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }
}
 