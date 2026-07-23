import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, answer;
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int maxArea = 0, answerK = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, graph[i][j]);
            }
        }

        for (int K = 1; K <= maxHeight; K++) {
            visited = new boolean[N][M];
            int area = 0;    
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && graph[i][j] > K) {
                        area++;
                        dfs(i, j, K);
                    }
                }
            }

            if (area > maxArea) {
                maxArea = area;
                answerK = K;
            }
        }

        System.out.println(answerK + " " + maxArea);

    }

    public static void dfs(int x, int y, int K) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!inRange(nx, ny)) continue;
            if (visited[nx][ny]) continue;
            if (graph[nx][ny] <= K) continue;
            
            dfs(nx, ny, K);
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
 