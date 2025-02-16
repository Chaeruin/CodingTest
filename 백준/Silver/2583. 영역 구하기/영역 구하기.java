
import java.util.*;
import java.io.*;

class Main {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static List<Integer> result;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], 0);
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            for (int x = startX; x < endX; x++) {
                for (int y = startY; y < endY; y++) {
                    map[x][y] = 1;
                }
            }
        }

        count = 1;
        for (int i = 0; i < N; i++) {
            for (int j =0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    bfs(i, j);
                    result.add(count);
                    count = 1;
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (int r: result) {
            System.out.print(r + " ");
        }

    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0 && !visited[nx][ny]) {
                    queue.add(new int[] {nx, ny});
                    count++;
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
