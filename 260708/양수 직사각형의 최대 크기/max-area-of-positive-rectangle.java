import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSize = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = i; k < N; k++) {
                    for (int l = j; l < M; l++) {
                        if (isInGridAllPositive(i, k, j, l)) {
                            maxSize = Math.max(maxSize, (k - i + 1) * (l - j + 1));
                        }
                    }
                }
            }
        }

        if (maxSize == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(maxSize);
    }

    public static boolean isInGridAllPositive(int x1, int x2, int y1, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (grid[i][j] <= 0) return false;
            }
        }
        return true;
    }
}
 