import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N, H;
    static int[][][] tomato;
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[N][M][H];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    tomato[n][m][h] = Integer.parseInt(st.nextToken());
                }
            }
        }

        bfs();
        checkTomato();

    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                     if (tomato[n][m][h] == 1) {
                         queue.add(new int[] {n, m, h});
                     }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] xyh = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = xyh[0] + dx[i];
                int ny = xyh[1] + dy[i];
                int nh = xyh[2] + dh[i];

                if (nx >= 0 && ny >= 0 && nh >= 0 && nx < N && ny < M && nh < H) {
                    if (tomato[nx][ny][nh] == 0) {
                        queue.add(new int[] {nx, ny, nh});
                        tomato[nx][ny][nh] = tomato[xyh[0]][xyh[1]][xyh[2]] + 1;
                    }
                }
            }
        }
    }

    static void checkTomato() {
        int days = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (tomato[n][m][h] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    days = Math.max(days, tomato[n][m][h]);
                }
            }
        }

        if (days == 1)
            System.out.println(0);
        else {
            System.out.println(days - 1);
        }
    }
}
