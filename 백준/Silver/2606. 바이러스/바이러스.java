import java.io.*;
import java.util.*;

public class Main {
    static int C, T;
    static int[][] graph;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        C = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());

        graph = new int[C + 1][C + 1];
        visited = new boolean[C + 1];

        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }

        dfs(1);

        System.out.println(result);
    }

    static void dfs(int x){
        visited[x] = true;
        
        for(int i = 1; i <= C; i++){
            if(graph[x][i] == 1 && !visited[i]){
                dfs(i);
                result++;
            }
        }
    }
}