import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] graph;
    static boolean[] visit;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N + 1][N + 1];
        visit = new boolean[N + 1];

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = true;
        }

        bfs(1);

        System.out.println(count);

    }

    public static void dfs(int v) {
        visit[v] = true;

        if (v == graph.length) {
            return;
        }
        for (int i = 1; i < graph.length; i++) {
            if (graph[v][i] && !visit[i]) {
                dfs(i);
                count++;
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visit[v] = true;

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int i = 1; i < graph.length; i++) {
                if (graph[tmp][i] && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                    count++;
                }
            }
        }
    }
}