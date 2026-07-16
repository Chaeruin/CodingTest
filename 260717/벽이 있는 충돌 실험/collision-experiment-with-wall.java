import java.io.*;
import java.util.*;

public class Main {
    public static int T, N, M;
    public static int[][] grid;
    public static int[][] cases;
    public static int[] dir;
    public static boolean[] isAlive;
    
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        for (int k = 0; k < T; k++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            grid = new int[N][N];
            cases = new int[M][2];
            dir = new int[M];
            isAlive = new boolean[M];
            
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                cases[i][0] = Integer.parseInt(st.nextToken()) - 1;
                cases[i][1] = Integer.parseInt(st.nextToken()) - 1;
                dir[i] = getDirIndex(st.nextToken().charAt(0));
                isAlive[i] = true;
            }

            for (int i = 0; i < M; i++) { 
                grid[cases[i][0]][cases[i][1]] = 1;
            }

            for (int i = 0; i < 2 * N; i++) { 
                grid = moveBead();
            }

            int count = 0;

            for (int i = 0; i < M; i++) {
                if (isAlive[i]) count++;
            }

            System.out.println(count);
        }
    }

    public static int[][] moveBead() {
        int[][] copy = new int[N][N];

        // M 개의 구슬에 대해
        // 방향대로 움직임
        for (int i = 0; i < M; i++) {
            if (!isAlive[i]) continue;

            int x = cases[i][0];
            int y = cases[i][1];
            int direction = dir[i];

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (!inRange(nx, ny)) {
                dir[i] = changeDir(dir[i]);
                copy[x][y]++;
            } else {
                cases[i][0] = nx;
                cases[i][1] = ny;
                copy[nx][ny]++;
            }
        }

        boolean flag = false;

        for (int i = 0; i < M; i++) {
            if (!isAlive[i]) continue; 

            int x = cases[i][0];
            int y = cases[i][1];

            if (copy[x][y] > 1) {
                isAlive[i] = false;
            }
        }
        
        return copy;
    }

    public static int getDirIndex(char dir) {
        if (dir == 'U') return 0;
        else if (dir == 'D') return 1;
        else if (dir == 'L') return 2;
        else if (dir == 'R') return 3;
        return -1;
    }

    public static int changeDir(int dir) {
        if (dir == 0) return 1;
        else if (dir == 1) return 0;
        else if (dir == 2) return 3;
        else if (dir == 3) return 2;
        return -1;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
 