import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
    }

    static void dfs(int x) {
        visited[x] = true;
        sb.append(x).append(" ");

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[x][i] == 1) {
                dfs(i);
            }
        }
    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        sb.append(x).append(" ");

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int i = 1; i < graph.length; i++) {
                if (graph[tmp][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
    }
}
