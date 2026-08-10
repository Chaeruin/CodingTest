import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int[] prefixSum = new int[N + 1];
        prefixSum[0] = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int count = 0;

        for (int i = 0; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                int sum = prefixSum[j] - prefixSum[i];
                if (sum == K) count++;
            }
        }

        System.out.println(count);
    }
}