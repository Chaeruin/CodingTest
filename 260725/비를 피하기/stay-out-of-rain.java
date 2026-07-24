import java.io.*;
import java.util.*;

public class Main {

    public static int N, H, M, answer;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int[][] grid;
    public static int[][] result;
    public static boolean[][] visited;

    // 0 이동 가능
    // 1 벽, 이동 불가
    // 2 사람
    // 3 비피할수있는곳

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        result = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 2) {
                    answer = 0;
                    bfs(i, j);
                    if (answer == 0) result[i][j] = -1;
                    else result[i][j] = answer;
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


    // 사람인 경우만 시행 (grid[x][y] == 2)
    public static void bfs(int x, int y) {
        visited = new boolean[N][N];
        visited[x][y] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (grid[cur[0]][cur[1]] == 3) {
                answer = cur[2];
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!inRange(nx, ny)) continue;
                if (grid[nx][ny] != 1 && !visited[nx][ny]) {
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