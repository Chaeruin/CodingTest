import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] L = new int[N];
        int[] R = new int[N];

        L[0] = 0;
        for(int i = 1; i < N; i++)
            L[i] = L[i - 1] + Math.abs(arr[i][0] - arr[i - 1][0]) + Math.abs(arr[i][1] - arr[i - 1][1]);
        
        // R 배열을 채워줍니다.
        R[N - 1] = 0;
        for(int i = N - 2; i >= 1; i--)
            R[i] = R[i + 1] + Math.abs(arr[i + 1][0] - arr[i][0]) + Math.abs(arr[i + 1][1] - arr[i][1]);
        
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < N - 1; i++) {
            ans = Math.min(ans, L[i - 1] + R[i + 1] + dist(arr[i - 1], arr[i + 1]));
        }

        System.out.println(ans);

    }

    static int dist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
 