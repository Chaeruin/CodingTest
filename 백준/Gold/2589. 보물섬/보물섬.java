import java.io.*;
import java.util.*;

public class Main {
    static String[][] map;
    static int N, M, count = 0;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals("L")) {
                    count = Math.max(count, bfs(i, j, 0));
                }
            }
        }

        System.out.println(count);
    }

    static int bfs(int row, int col, int distance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col, distance});

        visited = new boolean[N][M];
        visited[row][col] = true;

        int maxPath = 0;

        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            int r = index[0];
            int c = index[1];
            int d = index[2];

            maxPath = Math.max(maxPath, d);

            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny].equals("L") && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny, d + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return maxPath;
    }
}