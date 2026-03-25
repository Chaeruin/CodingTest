import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strA = br.readLine();
        String strB = br.readLine();

        int N = strA.length();
        int M = strB.length();

        dp = new int[N + 1][M + 1];


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (strA.charAt(i - 1) == strB.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(dp[N][M]);
    }
}