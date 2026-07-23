import java.io.*;
import java.util.*;

public class Main {

    public static int N, answer;
    public static int[][] grid;
    public static boolean[][] visited;
    public static List<Integer> bomb, noBomb;
    // list size + list 에서 최댓값
    // block list size == 0 -> 아닌 블록도 저장 필요
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N][N];
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bomb = new ArrayList<>();
        noBomb = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    answer = 0;
                    dfs(i, j);
                    if (answer >= 4) bomb.add(answer);
                    else noBomb.add(answer);
                }
            }
        }

        bomb.sort(Comparator.reverseOrder());
        noBomb.sort(Comparator.reverseOrder());

        if (bomb.size() != 0) {
            System.out.println(bomb.size() + " " + bomb.get(0));
        } else {
            System.out.println(bomb.size() + " " + noBomb.get(0));
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        answer++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!inRange(nx, ny)) continue;
            if (visited[nx][ny]) continue;
            if (grid[x][y] == grid[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
 