import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] tomato;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tomato = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = bfs();

        // 모든 토마토가 익었는지 확인
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (tomato[i][j] == 0) {
                    answer = -1; // 익지 않은 토마토가 있으면 -1 반환
                }
            }
        }

        System.out.println(answer);

    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();

        // 익은 토마토들 모두 큐에 추가
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (tomato[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int cnt = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
    
            for (int s = 0; s < size; s++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
    
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
    
                    if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny] && tomato[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        tomato[nx][ny] = 1;
                    }
                }
            }
        }

        return cnt;
    }
}
