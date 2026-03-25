import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] things, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        things = new int[N][2];
        dp = new int[N + 1][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            things[i][0] = Integer.parseInt(st.nextToken());
            things[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int w = things[i - 1][0];
            int v = things[i - 1][1];

            for (int j = 1; j <= K; j++) {
                if (j < w) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
            }
        }

        System.out.println(dp[N][K]);
    }
}
