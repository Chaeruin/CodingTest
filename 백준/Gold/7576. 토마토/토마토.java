import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] tomato;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomato = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) queue.add(new int[] {i, j, 0});
            }
        }

        bfs();
    }

    public static void bfs() {
        int day = 0;

        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            day = t[2];

            for (int i = 0; i < 4; i++) {
                int nx = t[0] + dx[i];
                int ny = t[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (tomato[nx][ny] == 0) {
                        tomato[nx][ny] = 1;
                        queue.add(new int[] {nx, ny, day + 1});
                    }
                }
            }
        }

        if (checkTomato()) System.out.println(day);
        else System.out.println(-1);
    }

    public static boolean checkTomato() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) return false;
            }
        }
        return true;
    }
}