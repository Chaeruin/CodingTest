import java.io.*;
import java.util.*;

public class Main {

    public static int N, K, startX, startY, endX, endY, answer = Integer.MAX_VALUE;
    public static int[][] grid;
    public static int[] selected;
    public static List<int[]> walls;
    public static boolean[][] visited;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        walls = new ArrayList<>();
        selected = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) walls.add(new int[] {i, j});
            }
        }

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        endX = Integer.parseInt(st.nextToken()) - 1;
        endY = Integer.parseInt(st.nextToken()) - 1;


        removeWall(0, 0);

        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }   

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][N];

        queue.add(new int[] {startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == endX && cur[1] == endY) {
                answer = Math.min(answer, cur[2]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!inRange(nx, ny)) continue;
                if (grid[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, cur[2] + 1});
                }
            }
        }
    }

    public static void removeWall(int depth, int start) {
        if (depth == K) {
            for (int i = 0; i < K; i++) {
                int[] wall = walls.get(selected[i]);
                grid[wall[0]][wall[1]] = 0;
            }

            bfs();

            for (int i = 0; i < K; i++) {
                int[] wall = walls.get(selected[i]);
                grid[wall[0]][wall[1]] = 1;
            }

            return;
        }

        for (int i = start; i < walls.size(); i++) {
            selected[depth] = i;
            removeWall(depth + 1, i + 1);
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
 