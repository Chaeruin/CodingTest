import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int MAX_RANGE = 1005;
        int[] arr = new int[MAX_RANGE];

        int maxPos = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            arr[idx] += num;
            maxPos = Math.max(maxPos, idx);
        }

        int max = 0;
        int limit = Math.min(MAX_RANGE - 1, maxPos + K);

        for (int i = 0; i <= limit; i++) {
            int sum = 0;
            
            int start = Math.max(0, i - K);
            int end = Math.min(MAX_RANGE - 1, i + K);
            
            for (int j = start; j <= end; j++) {
                sum += arr[j];
            }
            
            max = Math.max(max, sum);
        }

        System.out.print(max);
    }
}



