import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] flower;
    static boolean[][] visited;
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int ans= Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        flower = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                flower[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(ans);
    }

    public static void dfs(int level,  int sum) {
        if(level == 3) {
            ans = Math.min(ans, sum);
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(isPossible(i, j)) {
                    int tmp_sum = get_sum(i, j);
                    setting_visited(i, j,true);
                    dfs(level + 1,sum + tmp_sum);
                    setting_visited(i, j,false);
                }
            }
        }

    }
    public static int get_sum(int x, int y) {
        int sum = flower[x][y];
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            sum += flower[nx][ny];
        }
        return sum;
    }
    public static void setting_visited(int x, int y, boolean flag) {
        visited[x][y] = flag;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[nx][ny] = flag;
        }
    }
    public static boolean isPossible(int x, int y) {
        if(visited[x][y]) {
            return false;
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!isRange(nx, ny)) {
                return false;
            }
            if(visited[nx][ny]) {
                return false;
            }
        }
        return true;
    }
    public static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
