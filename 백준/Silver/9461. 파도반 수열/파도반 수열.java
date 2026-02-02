
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[] dp = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // 1 : 1
        // 2 : 1
        // 3 : 1
        // 4 : 2
        // 5 : 2
        // 6 : 3
        // 7 : 4
        // 8 : 5
        // 9 : 7
        // 10 : 9
        // 11 : 12
        // 12 : 16
        // 점화식 : dp[n] = dp[n - 1] + dp[n - 5]

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = 3;

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            if (N <= 6) sb.append(dp[N]).append("\n");
            else {
                for (int i = 6; i <= N; i++) {
                    dp[i] = dp[i - 1] + dp[i - 5];
                }
                sb.append(dp[N]).append("\n");
            }
        }
        System.out.println(sb);
    }
}