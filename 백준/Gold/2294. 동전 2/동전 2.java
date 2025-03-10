
import java.util.*;
import java.io.*;

public class Main {

    static int n, k;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        dp = new int[k + 1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= k; i++){
            dp[i] = Integer.MAX_VALUE-1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = arr[i]; j <= k; j++){
                dp[j] = Math.min(dp[j], dp[j-arr[i]]+1);
            }
        }

        if(dp[k] == Integer.MAX_VALUE-1)
            System.out.println(-1);
        else
            System.out.println(dp[k]);
    }
}
