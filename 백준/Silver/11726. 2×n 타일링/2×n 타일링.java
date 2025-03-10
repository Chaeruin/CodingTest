import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            if (i == 2) dp[2] = 2;
            else dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        
        System.out.println(dp[N]);
    }
}