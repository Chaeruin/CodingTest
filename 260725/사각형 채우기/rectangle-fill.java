import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] dp;
    public static int MAX_N = 1000, MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[MAX_N + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        // dp[4] = 5;

        for (int i = 4; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        
        System.out.println(dp[N]);
    }
}
 