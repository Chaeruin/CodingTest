import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[][] grid;
    public static int[][] dp;
    // 우 , 하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        dp = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = grid[0][0];

        for (int i = 1; i < N; i++) {
            dp[0][i] = Math.min(dp[0][i - 1], grid[0][i]);
        }

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], grid[i][0]);
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.min(Math.max(dp[i - 1][j], dp[i][j - 1]), grid[i][j]);
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}