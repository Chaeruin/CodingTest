import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, K;
    public static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) - 1;

        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();

        if (N == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == N - 1 && grid[i][K] == 0) {
                for (int j = K; j < K + M; j++) {
                    grid[i][j] = 1;
                }
                break;
            }
            else if (isNext1(i)) {
                for (int j = K; j < K + M; j++) {
                    if (!inRange(j)) continue;
                    grid[i - 1][j] = 1;
                }
                break;
            }
            
        }

        for (int[] arr : grid) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static boolean isNext1(int idx) {
        for (int j = K; j < K + M; j++) {
            if (inRange(j) && grid[idx][j] == 1) return true;
        }
        return false;
    }

    public static boolean inRange(int j) {
        return j >= 0 && j < N;
    }
}
 