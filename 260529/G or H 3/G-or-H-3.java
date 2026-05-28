import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[10001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            if (c == 'G') arr[index] = 1;
            else arr[index] = 2;
        }

        int maxSum = 0;
        for(int i = 0; i <= 10000 - K; i++) {
            int sum = 0;
            for(int j = i; j <= i + K; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        
        System.out.println(maxSum);
    }
}



