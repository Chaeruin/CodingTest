import java.io.*;
import java.util.*;

public class Main {

    public static int N, answer = Integer.MAX_VALUE;
    public static int[][] grid;
    public static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N];
        visited[0] = true;
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);

        System.out.println(answer);
    }

    public static void dfs(int current, int depth, int sum) {
        if (depth == N) {
            if (grid[current][0] != 0) {
                answer = Math.min(answer, sum + grid[current][0]);
            }
            return;
        }

        for (int k = 0; k < N; k++) {
            if (visited[k]) continue;
            if (grid[current][k] == 0) continue;
            visited[k] = true;
            dfs(k, depth + 1, sum + grid[current][k]);
            visited[k] = false;
        }
    }
}
 