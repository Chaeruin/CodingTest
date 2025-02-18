import java.util.*;
import java.io.*;

class Main {

    static int N, M, K;
    static int[][] arr;
    static int[][] idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        K = Integer.parseInt(br.readLine());
        
        idx = new int[K][4];
        
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            idx[i][0] = Integer.parseInt(st.nextToken());
            idx[i][1] = Integer.parseInt(st.nextToken());
            idx[i][2] = Integer.parseInt(st.nextToken());
            idx[i][3] = Integer.parseInt(st.nextToken());
        }
        
        for (int k = 0; k < K; k++) {
            int sum = 0;
            for (int i = idx[k][0]; i <= idx[k][2]; i++) {
                for (int j = idx[k][1]; j <= idx[k][3]; j++) {
                    sum += arr[i - 1][j - 1];
                }
            }
            System.out.println(sum);
        }
        
    }
}