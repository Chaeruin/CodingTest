import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int max = 0, count;
    static int answer = 1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }

        for (int h = 1; h <= max; h++) {
            visited = new boolean[N][N];
            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] > h && !visited[i][j]) {
                        count++;
                        dfs(i, j, h);
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
    static void dfs(int x, int y, int h) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if ((nx >= 0 && nx < N) && (ny >= 0 && ny < N) && !visited[nx][ny] && arr[nx][ny] > h) {
                dfs(nx, ny, h);
            }
        }
    }
}
