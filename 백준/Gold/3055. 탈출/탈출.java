
import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<int[]> hedgehogQueue = new LinkedList<>();
    static Queue<int[]> waterQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == 'S') {
                    hedgehogQueue.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                } else if (arr[i][j] == '*') {
                    waterQueue.add(new int[]{i, j});
                }
            }
        }

        int result = bfs();
        System.out.println(result == -1 ? "KAKTUS" : result);
    }

    static int bfs() {
        while (!hedgehogQueue.isEmpty()) {
      
            spreadWater();

            int len = hedgehogQueue.size();
            for (int i = 0; i < len; i++) {
                int[] current = hedgehogQueue.poll();
                int x = current[0];
                int y = current[1];
                int time = current[2];

                for (int t = 0; t < 4; t++) {
                    int nx = x + dx[t];
                    int ny = y + dy[t];

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue; 
                    if (arr[nx][ny] == 'D') return time + 1; 
                    if (arr[nx][ny] == '.' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        hedgehogQueue.add(new int[]{nx, ny, time + 1});
                    }
                }
            }
        }
        return -1; 
    }

    static void spreadWater() {
        int len = waterQueue.size();
        for (int i = 0; i < len; i++) {
            int[] current = waterQueue.poll();
            int x = current[0];
            int y = current[1];

            for (int t = 0; t < 4; t++) {
                int nx = x + dx[t];
                int ny = y + dy[t];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue; 
                if (arr[nx][ny] == '.') {
                    arr[nx][ny] = '*';
                    waterQueue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
