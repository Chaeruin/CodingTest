import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int count;
    static int N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        StringBuilder sb = new StringBuilder();

        int num = 0;
        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    count = 0;
                    dfs(i, j);
                    counts.add(count);
                    num++;
                }
            }
        }

        sb.append(num).append("\n");

        counts.sort(Comparator.naturalOrder());

        for (int c : counts) {
            sb.append(c).append("\n");
        }

        System.out.print(sb);
    }

    public static void dfs(int x, int y) {
        visit[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1 && !visit[nx][ny]) {
                dfs(nx, ny);
            }
        }

    }
}
