import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int MAX_N = 1000, MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        long[] dp = new long[Math.max(N + 1, 3)];
        long[] sum = new long[Math.max(N + 1, 3)];

        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 7;

        sum[0] = dp[0];
        sum[1] = (sum[0] + dp[1]) % MOD;
        sum[2] = (sum[1] + dp[2]) % MOD;

        for (int i = 3; i <= N; i++) {
            dp[i] = (2 * dp[i - 1]
                    + 3 * dp[i - 2]
                    + 2 * sum[i - 3]) % MOD;

            sum[i] = (sum[i - 1] + dp[i]) % MOD;
        }
        
        System.out.println(dp[N]);
    }
}