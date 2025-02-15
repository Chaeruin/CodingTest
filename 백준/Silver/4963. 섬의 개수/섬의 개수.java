import java.util.*;
import java.io.*;

class Main {
    static int W, H;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        while (W != 0 && H != 0) {
            map = new int[H][W];
            visited = new boolean[H][W];

            for (int h = 0; h < H; h++) {
                st = new StringTokenizer(br.readLine());
                for (int w = 0; w < W; w++) {
                    map[h][w] = Integer.parseInt(st.nextToken());
                }
            }

            count = 0;
            for (int h = 0; h < H; h++) {
                for (int w = 0; w < W; w++) {
                    if (map[h][w] == 1 && !visited[h][w]) {
                        bfs(h, w);
                        count++;
                    }
                }
            }

            System.out.println(count);

            st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
        }
    }

    static void bfs(int h, int w) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{h, w});
        visited[h][w] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
