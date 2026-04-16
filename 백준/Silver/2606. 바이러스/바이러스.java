
import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] graph;
    static boolean[] visited;
    static int C, L, count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        C = Integer.parseInt(br.readLine());
        L = Integer.parseInt(br.readLine());

        graph = new boolean[C + 1][C + 1];
        visited = new boolean[C + 1];

        StringTokenizer st;

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = true;
        }

        dfs(1);
        System.out.println(count);
    }

    static void dfs(int x) {
        visited[x] = true;

        for(int i = 1; i <= C; i++){
            if(graph[x][i] && !visited[i]){
                dfs(i);
                count++;
            }
        }
    }
}
