import java.io.*;
import java.util.*;

public class Main {

    public static int N, K, answer;
    public static int[][] grid;
    // public static int[][] rottenOrange;
    public static int[][] result;
    public static boolean[][] visited;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    // 0 무
    // 1 귤
    // 2 상한귤
    // 1초마다 인접귤 상함

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        result = new int[N][N];
        // rottenOrange = new int[K][2];
        int idx = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 0) result[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 0) {
                    answer = 0;
                    bfs(i, j);
                    result[i][j] = answer;

                    if (grid[i][j] == 1 && answer == 0) 
                        result[i][j] = -2;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int[] arr : result) {
            for (int r : arr) {
                sb.append(r).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][N];

        visited[x][y] = true;
        queue.add(new int[] {x, y, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (grid[cur[0]][cur[1]] == 2) {
                answer = cur[2];
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!inRange(nx, ny)) continue;
                if (!visited[nx][ny] && grid[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, cur[2] + 1});
                }
            }
        }

    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}