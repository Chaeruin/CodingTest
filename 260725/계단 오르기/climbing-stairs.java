import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[1001];

        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        
        for (int i = 4; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 3]) % 10_007;
        }

        System.out.println(dp[N]);
    }
}