import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, Q;
    public static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;
            
            changeByWind(r1, c1, r2, c2);
            changeAsAvg(r1, c1, r2, c2);
        }

        for (int[] arr : grid) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void changeByWind(int r1, int c1, int r2, int c2) {
        int temp = grid[r1][c1];

        for (int i = r1; i < r2; i++) {
            grid[i][c1] = grid[i + 1][c1];
        }

        for (int i = c1; i < c2; i++) {
            grid[r2][i] = grid[r2][i + 1];
        }

        for (int i = r2; i > r1; i--) {
            grid[i][c2] = grid[i - 1][c2];
        }

        for (int i = c2; i > c1; i--) {
            grid[r1][i] = grid[r1][i - 1];
        }

        grid[r1][c1 + 1] = temp;
    }

    public static void changeAsAvg(int r1, int c1, int r2, int c2) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = grid[i].clone(); 
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                int sum = copy[i][j]; 
                int count = 1;

                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                        sum += copy[nr][nc];
                        count++;
                    }
                }

                grid[i][j] = sum / count;
            }
        }
    }

}
 