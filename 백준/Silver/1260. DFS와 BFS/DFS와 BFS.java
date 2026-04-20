
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static boolean[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = true;
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    static void dfs(int v) {
        sb.append(v).append(" ");
        visited[v] = true;

        for (int i = 1; i <= N; i++) {
            if (graph[v][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        sb.append(v).append(" ");
        visited[v] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (graph[x][i] && !visited[i]) {
                    sb.append(i).append(" ");
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
