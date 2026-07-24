import java.io.*;
import java.util.*;

public class Main {

    public static int N, K;
    public static int[][] grid;
    public static boolean[][] visited;

    public static int bestX = -1, bestY = -1, bestValue, startX, startY;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;

        int x = startX;
        int y = startY;

        for (int i = 0; i < K; i++) {
            bfs(x, y);   

            if (bestX == -1)
                break;

            x = bestX;
            y = bestY;
        }

        System.out.println((x + 1) + " " + (y + 1));
    }


    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][N];

        int startValue = grid[x][y];

        bestX = -1;
        bestY = -1;
        bestValue = -1;
        
        visited[x][y] = true;
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!inRange(nx, ny)) continue;
                if (grid[nx][ny] < startValue && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    getBestXY(nx, ny);
                    queue.add(new int[] {nx, ny});
                }
            }

        }
    }

    public static void getBestXY(int x, int y) {
        if (bestX == -1 || grid[x][y] > bestValue) {
            bestX = x;
            bestY = y;
            bestValue = grid[x][y];
        } 
        else if (grid[x][y] == bestValue) {
            if (x < bestX) {
                bestX = x;
                bestY = y;
            }
            else if (x == bestX && y < bestY) {
                bestX = x;
                bestY = y;
            }
        }

    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
// 인접 + 그 주변 현재 값보다 작은 점으로 이동 가능 - 둘러쌓이는거 기준
// 이동 가능한 칸 중 최댓값으로 이동
// 최댓값이 여러개일 경우 행번호가 가장 작은 곳/열번호가 가장 작은 곳 -> 을 어떻게 산출할건지.
// 이동 K 번 반복 - 반복 못했더라도 새로 이동할 위치가 없다면 종료