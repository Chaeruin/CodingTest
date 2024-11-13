import java.util.*;
import java.io.*;

public class Solution {
    static int[][] farm;
    static int income;
    static int N;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int i = 1; i <= TC; i++) {
            N = Integer.parseInt(br.readLine());

            farm = new int[N][N];
            visited = new boolean[N][N];
            income = 0;

            for (int j = 0; j < N; j++) {
                String[] st = br.readLine().split("");
                for (int k = 0; k < N; k++) {
                    farm[j][k] = Integer.parseInt(st[k]);
                }
            }

            setVisited();

            // 중앙 값을 수익에 추가하고 BFS 시작
            income += farm[N / 2][N / 2];
            bfs(new int[]{N / 2, N / 2});

            System.out.printf("#%d %d\n", i, income);
        }
    }

    public static void bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    income += farm[nx][ny];
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void setVisited() {
        // 초기에는 모든 위치를 방문 불가능(true)으로 설정
        for (boolean[] a : visited) Arrays.fill(a, true);
        
        int fill = 0;
        for (int i = 0; i <= N / 2; i++) {
            // 다이아몬드 영역만 방문 가능(false)으로 설정
            for (int j = N / 2 - fill; j <= N / 2 + fill; j++) {
                visited[i][j] = false;
                visited[(N - 1) - i][j] = false;
            }
            fill++;
        }
    }
}
