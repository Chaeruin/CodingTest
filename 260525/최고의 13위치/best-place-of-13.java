import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 2; j++) {
                maxCount = Math.max(maxCount, arr[i][j] + arr[i][j + 1] + arr[i][j + 2]);
            }
        }

        System.out.println(maxCount);
    }
}