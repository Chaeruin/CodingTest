
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] step;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        step = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                dp[1] = step[1];
            }
            else if (i == 2) {
                dp[2] = step[1] + step[2];
            } else {
                dp[i] = Math.max(dp[i - 2], dp[i - 3] + step[i - 1]) + step[i];
            }
        }

        System.out.println(dp[N]);

    }
}
