
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] grid = new int[h][w];
        int[][][] dp = new int[h][w][3];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < 3; j++) {
                dp[0][i][j] = grid[0][i];
            }
        }

        for (int i = 1; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // 방향 : 0 → 왼쪽, 1 → 가운데, 2 → 오른쪽
                if (j == 0) {
                    dp[i][j][0] = 700;
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + grid[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + grid[i][j];
                } else if (j == w - 1) {
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + grid[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + grid[i][j];
                    dp[i][j][2] = 700;
                } else {
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + grid[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + grid[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + grid[i][j];
                }
            }
        }

        int min = 700;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < 3; j++) {
                min = Math.min(min, dp[h - 1][i][j]);
            }
        }

        System.out.println(min);
    }
}
