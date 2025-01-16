
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] dp;
    static int[] trace;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        trace = new int[N + 1];

        dp[0] = dp[1] = 0;
        trace[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            trace[i] = i - 1;
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                trace[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                trace[i] = i / 3;
            }
        }


        System.out.println(dp[N]);
        int current = N;
        while (current > 0) {
            System.out.print(current +  " ");
            current = trace[current];
        }

    }
}
