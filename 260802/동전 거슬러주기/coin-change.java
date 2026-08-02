import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[] arr;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[M + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i <= M; i++)
            dp[i] = 10001;

        dp[0] = 0;

        for (int i = 1; i <= M; i++) {
            for(int j = 0; j < N; j++) {
                if(i >= arr[j])
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
            }
        }

        if (dp[M] == 10001) System.out.println(-1);
        else System.out.println(dp[M]);
    }
}
 