import java.io.*;
import java.util.*;

public class Main {

    public static int N, r, c;
    public static int[][] grid;
    public static int[][] arrow;

    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        arrow = new int[N][N];
        
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arrow[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;


        dfs(r, c, 0);

        System.out.println(answer);
    }

    public static void dfs(int r, int c, int cnt) {
        answer = Math.max(answer, cnt);

        int idx = arrow[r][c];

        int dX = dx[idx];
        int dY = dy[idx]; 

        for (int i = 1; i < N; i++) {
            int nx = r + dX * i;
            int ny = c + dY * i;

            if (inRange(nx, ny) && grid[r][c] < grid[nx][ny]) {
                dfs(nx, ny, cnt + 1);
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    
}
 