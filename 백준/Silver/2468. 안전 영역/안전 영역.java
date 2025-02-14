import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] map;
    static int count = 0;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        
        StringTokenizer st;
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }
        
        int answer = 0;
        for (int k = 0; k <= max; k++) {
            visited = new boolean[N][N];
            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > k && !visited[i][j]) {
                        dfs(k, i, j);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        
        System.out.println(answer);
        
    }
    
    static void dfs(int pivot, int x, int y) {
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] > pivot && !visited[nx][ny]) {
                dfs(pivot, nx, ny);
            }
        }
    }
}