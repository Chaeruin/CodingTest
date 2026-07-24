import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[][] grid;
    public static boolean[][] visited;
    public static Queue<int[]> queue = new LinkedList<>();
    public static int answer = 0;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        System.out.println(answer);
    }

    public static void bfs() {
        visited[0][0] = true;
        queue.add(new int[] {0, 0});

        while (!queue.isEmpty()) {
            int[] coord = queue.poll();

            if (coord[0] == N - 1 && coord[1] == M - 1) {
                answer = 1;
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = coord[0] + dx[i];
                int ny = coord[1] + dy[i];

                if (!inRange(nx, ny)) continue;
                if (grid[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }

    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
 