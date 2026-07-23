import java.io.*;
import java.util.*;

public class Main {

    public static int N, answer = 0;
    public static int[][] grid;
    public static boolean[] colVisited;
    public static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        selected = new int[N];
        colVisited = new boolean[N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int row) {
        if (row == N) {
            answer = Math.max(answer, getMinValue());
            return;
        }

        for (int col = 0; col < N; col++) {
            if (colVisited[col]) continue;

            colVisited[col] = true;
            selected[row] = grid[row][col];
            dfs(row + 1);
            colVisited[col] = false;
        }
    }

    public static int getMinValue() {
        int ans = Integer.MAX_VALUE;

        for (int i : selected) {
            ans = Math.min(ans, i);
        }

        return ans;
    }
}
 