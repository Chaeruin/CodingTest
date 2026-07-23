import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, answer;
    public static int[][] graph;
    public static boolean[][] visited;

    public static int[] dx = {1, 0};
    public static int[] dy = {0, 1};

    // 탈출 가능 : 1 / 탈출 불가 = 0
    // 아래 오른쪽 중 인접한 칸으로만 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int x, int y) {

        if (x == N - 1 && y == M - 1) {
            answer = 1;
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (canGo(nx, ny)) {
                dfs(nx, ny);
            }
        }
    }

    public static boolean canGo(int x, int y) {
        if (!inRange(x, y)) return false;
        if (visited[x][y] || graph[x][y] == 0) return false;
        return true;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}