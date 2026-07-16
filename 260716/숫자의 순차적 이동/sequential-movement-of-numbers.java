import java.io.*;
import java.util.*;

public class Main {

    // 여덟방향 dir
    // 상 하 좌 우 좌상 우상 좌하 우하
    public static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    public static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    public static int[][] grid, pos, copy;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        pos = new int[N * N + 1][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int num = grid[r][c];
                pos[num][0] = r; 
                pos[num][1] = c;
            }
        }

        for (int l = 0; l < M; l++) {
            grid = shiftTurn();
        }

        StringBuilder sb = new StringBuilder();

        for (int[] arr : grid) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static int[][] shiftTurn() {
        copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = grid[i].clone();
        }

        for (int i = 1; i <= N * N; i++) {
            int x = pos[i][0];
            int y = pos[i][1];

            int maxValue = -1;
            int dir = -1;
            
            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (inRange(nx, ny) && maxValue < copy[nx][ny]) {
                    maxValue = copy[nx][ny];
                    dir = d;
                }
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            int targetNum = copy[nx][ny];

            int temp = copy[x][y];
            copy[x][y] = copy[nx][ny];
            copy[nx][ny] = temp;

            pos[i][0] = nx;
            pos[i][1] = ny;
            pos[targetNum][0] = x;
            pos[targetNum][1] = y;
        }

        return copy;
    }

    public static int getMaxDir(int x, int y) {
        int maxValue = -1;
        int dir = -1;
        
        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (inRange(nx, ny) && maxValue < grid[nx][ny]) {
                maxValue = grid[nx][ny];
                dir = d;
            }
        }

        return dir;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
 