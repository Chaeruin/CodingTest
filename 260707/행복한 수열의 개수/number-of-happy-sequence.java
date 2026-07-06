import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxCount = 0;

        for (int i = 0; i < N; i++) {
            int maxLen = 1; 
            int count = 1; 

            for (int j = 0; j < N - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) count++;
                else {
                    maxLen = Math.max(maxLen, count); 
                    count = 1;
                }
            }
            maxLen = Math.max(maxLen, count);

            if (maxLen >= M) maxCount++;
        }

        for (int i = 0; i < N; i++) {
            int maxLen = 1; 
            int count = 1;

            for (int j = 0; j < N - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) count++;
                else {
                    maxLen = Math.max(maxLen, count); 
                    count = 1;
                }
            }
            maxLen = Math.max(maxLen, count);

            if (maxLen >= M) maxCount++;
        }

        System.out.println(maxCount);
    }
}
