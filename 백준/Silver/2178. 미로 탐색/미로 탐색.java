import java.util.*;
import java.io.*;

public class Main {
    
    static boolean[][] visited;
    static int[][] maze;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] mazeStrings = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(mazeStrings[j]);
            }
        }

        int answer = bfs(N, M);
        System.out.println(answer);

    }

    public static int bfs(int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        maze[0][0] = 1; // 시작 지점에서의 거리

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            // 목표 지점 도달 시 거리 반환
            if (x == n - 1 && y == m - 1) {
                return maze[x][y];
            }
            
            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 범위 내에 있고, 방문하지 않은 이동 가능한 칸이면
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == 1) {
                    queue.add(new int[] {nx, ny});
                    maze[nx][ny] = maze[x][y] + 1; // 이동 거리 업데이트
                }
            }
        }
        
        return -1;
    }
}
