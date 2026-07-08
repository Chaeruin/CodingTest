import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, Q;
    public static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            char dir = st.nextToken().charAt(0);

            boolean[] visited = new boolean[N];
            processChainRotation(row, dir, visited);
        }

        for (int[] arr : grid) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void processChainRotation(int curRow, char dir, boolean[] visited) {
        visited[curRow] = true;
        
        shiftGrid(curRow, dir);

        if (curRow - 1 >= 0 && !visited[curRow - 1]) {
            if (hasDuplicate(curRow, curRow - 1)) {
                if (dir == 'R') processChainRotation(curRow - 1, 'L', visited);
                if (dir == 'L') processChainRotation(curRow - 1, 'R', visited);
            }
        }

        if (curRow + 1 < N && !visited[curRow + 1]) {
            if (hasDuplicate(curRow, curRow + 1)) {
                if (dir == 'R') processChainRotation(curRow + 1, 'L', visited);
                if (dir == 'L') processChainRotation(curRow + 1, 'R', visited);
            }
        }
    }

    public static boolean hasDuplicate(int r1, int r2) {
        for (int c = 0; c < M; c++) {
            if (grid[r1][c] == grid[r2][c]) {
                return true;
            }
        }
        return false;
    }

    public static void shiftGrid(int row, char dir) {
        if (dir == 'L') {
            int temp = grid[row][M - 1];
            for (int i = M - 1; i > 0; i--) {
                grid[row][i] = grid[row][i - 1];
            }
            grid[row][0] = temp;
        } else if (dir == 'R') {
            int temp = grid[row][0];
            for (int i = 0; i < M - 1; i++) {
                grid[row][i] = grid[row][i + 1];
            }
            grid[row][M - 1] = temp;
        }
    }
}
 