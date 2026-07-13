import java.io.*;
import java.util.*;

public class Main {
    
    public static int N, M, r, c;
    public static boolean[][] bombGrid;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;

        bombGrid = new boolean[N][N];
        bombGrid[r][c] = true;

        for (int t = 1; t <= M; t++) {
            bomb(t);
        }

        int count = 0;

        for (boolean[] arr : bombGrid) {
            for (boolean b : arr) {
                if (b) count++;
            }
        }

        System.out.println(count);
    
    }

    public static void bomb(int t) {
        int piv = (int) Math.pow(2, t - 1);
        boolean[][] copy = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            copy[i] = bombGrid[i].clone();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (copy[i][j]) {
                    for (int l = 0; l < 4; l++) {
                        int nx = i + piv * dx[l];
                        int ny = j + piv * dy[l];

                        if (inRange(nx, ny)) bombGrid[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
 