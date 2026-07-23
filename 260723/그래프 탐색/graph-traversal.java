import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, answer = 0;
    public static boolean[][] graph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        visited[1] = true;

        dfs(1);

        System.out.println(answer);
    }

    public static void dfs(int v) {
        for (int i = 1; i <= N; i++) {
            if (!graph[v][i]) continue;
            if (visited[i]) continue;

            visited[i] = true;
            answer++;
            dfs(i);
        }
    }
}