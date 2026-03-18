import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] map;
    static int N, M, V;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = true;
        }

        visit = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        visit = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    public static void dfs(int v) {
        visit[v] = true;
        sb.append(v).append(" ");

        if (v == map.length) {
            return;
        }
        for (int i = 1; i < map.length; i++) {
            if (map[v][i] && !visit[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visit[v] = true;
        sb.append(v).append(" ");

        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int i = 1; i < map.length; i++) {
                if (map[tmp][i] && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
    }
}