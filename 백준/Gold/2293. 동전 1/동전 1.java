import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] coins, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[N];
        dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= K; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }

        System.out.println(dp[K]);
    }
}
