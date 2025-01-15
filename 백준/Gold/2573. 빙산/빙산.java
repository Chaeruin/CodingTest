
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] iceBerg;
    static int[][] iceBergClone;
    static Queue<int[]> meltPoint;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        iceBerg = new int[N][M];
        iceBergClone = new int[N][M];
        meltPoint = new LinkedList<>();
        visited = new boolean[N][M];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                iceBerg[n][m] = Integer.parseInt(st.nextToken());
                if (iceBerg[n][m] != 0) {
                    meltPoint.add(new int[] {n, m});
                }
            }
        }

        int time = 0;

        while (true) {
            visited = new boolean[N][M];
            int parts = separateNum();

            if (parts >= 2) {
                System.out.println(time);
                return;
            }
            if (parts == 0) {
                System.out.println(0);
                return;
            }

            melt();
            time++;
        }

    }
    public static int separateNum() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (iceBerg[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (!visited[nx][ny] && iceBerg[nx][ny] != 0) {
                dfs(nx, ny);
            }
        }

    }

    public static void melt() {
        Queue<int[]> queue = new LinkedList<>();

        boolean[][] visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (iceBerg[i][j] != 0) {
                    queue.add(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            int seaNum = 0;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (!visited[nx][ny] && iceBerg[nx][ny] == 0) {
                    seaNum++;
                }
            }

            iceBerg[x][y] = Math.max(iceBerg[x][y] - seaNum, 0);
        }
    }

}
