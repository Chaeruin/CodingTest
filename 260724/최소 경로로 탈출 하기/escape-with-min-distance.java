import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, answer = 0;
    public static int[][] grid;
    public static boolean[][] visited;

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

        if (answer == 0) System.out.println(-1);
        else System.out.println(answer);
    }

    public static void bfs() {
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {0, 0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == N - 1 && cur[1] == M - 1) {
                answer = cur[2];
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!inRange(nx, ny)) continue;
                if (grid[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, cur[2] + 1});
                }
            }
        } 
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
 