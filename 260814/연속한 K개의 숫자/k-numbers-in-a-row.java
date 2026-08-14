import java.io.*;
import java.util.*;

public class Main {

    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100000;
    
    public static int N, K, B;
    public static int[] arr = new int[MAX_N + 1];
    public static int[] prefixSum = new int[MAX_N + 1];
    public static int ans = INT_MAX;
    
    public static int getSum(int s, int e) {
        return prefixSum[e] - prefixSum[s - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        for (int i = 0; i < B; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[x] = 1;
        }
        prefixSum[0] = 0;
        for(int i = 1; i <= N; i++)
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        
        for(int i = 1; i <= N - K + 1; i++)
            ans = Math.min(ans, getSum(i, i + K - 1));

        System.out.print(ans);
    }
}
 