import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = new int[] {0, 0, -1, 1};
    static int[] dy = new int[] {1, -1, 0, 0};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        List<Integer> answer = new ArrayList<>();

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count = 0;
                if (!visited[i][j] && arr[i][j] == 1) {
                    dfs(i, j);
                    answer.add(count);
                }
            }
        }
        if (answer.size() == 0) {
            System.out.println(0);
            System.out.println(0);
        } else {
            Collections.sort(answer);
            System.out.println(answer.size());
            System.out.println(answer.get(answer.size() - 1));
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && arr[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

   
}
