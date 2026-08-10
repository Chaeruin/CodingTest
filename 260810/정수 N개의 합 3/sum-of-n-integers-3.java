import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][N + 1];
        int[][] prefixSum = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            prefixSum[0][i] = 0;
            prefixSum[i][0] = 0;
        }


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                prefixSum[i][j] = prefixSum[i - 1][j] + 
                                  prefixSum[i][j - 1] -
                                  prefixSum[i - 1][j - 1] +
                                  arr[i][j];
            }
        }
            
        int sum = 0;

        for (int i = 1; i <= N - K + 1; i++) {
            for (int j = 1; j <= N - K + 1; j++) {
                int area = prefixSum[i + K - 1][j + K - 1] 
                        - prefixSum[i - 1][j + K - 1]
                        - prefixSum[i + K - 1][j - 1]
                        + prefixSum[i - 1][j - 1];
                sum = Math.max(sum, area);
            }
        }

        System.out.println(sum);
    }
}
 


