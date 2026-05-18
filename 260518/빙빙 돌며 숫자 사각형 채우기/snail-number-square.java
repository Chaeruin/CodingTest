import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[][] answer;

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int x = 0, y = 0;
    public static int dir = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        answer = new int[N][M];

        answer[x][y] = 1;

        for (int i = 2; i <= N * M; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!inRange(N, M, nx, ny) || answer[nx][ny] != 0) 
                dir = (dir + 1) % 4;
            
            x += dx[dir];
            y += dy[dir];

            answer[x][y] = i;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        } 
    }

    static boolean inRange(int N, int M, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }
}