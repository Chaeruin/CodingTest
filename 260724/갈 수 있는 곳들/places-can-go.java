import java.io.*;
import java.util.*;

public class Main {

    public static int N, K, answer = 0;
    public static int[][] grid;
    public static int[][] coord;
    public static boolean[][] visited;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static Queue<int[]> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        coord = new int[K][2];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            coord[i][0] = Integer.parseInt(st.nextToken()) - 1;
            coord[i][1] = Integer.parseInt(st.nextToken()) - 1;
            queue.add(new int[] {coord[i][0], coord[i][1]});
            visited[coord[i][0]][coord[i][1]] = true;
        }

        bfs();

        System.out.println(answer);
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] cxy = queue.poll();
            answer++;

            for (int i = 0; i < 4; i++) {
                int nx = cxy[0] + dx[i];
                int ny = cxy[1] + dy[i];

                if (!inRange(nx, ny)) continue;
                if (grid[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
 