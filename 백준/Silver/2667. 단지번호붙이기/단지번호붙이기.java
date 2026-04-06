import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int count;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new boolean[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = input.charAt(j) == '1';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        list.sort(Comparator.naturalOrder());

        sb.append(list.size()).append("\n");
        for (int l : list) {
            sb.append(l).append("\n");
        }

        System.out.print(sb);
    }

    static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        count = 1;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }

        list.add(count);
    }
}
