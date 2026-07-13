import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, r, c;
    public static int[][] grid;
    public static char[] dir;
    // L R U D
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    // 주사위 default - 윗면, 아랫면, 앞면, 뒷면, 좌측면, 우측면 
    public static int[] dice = {1, 6, 2, 5, 4, 3};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;

        grid = new int[N][N];
        dir = new char[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            dir[i] = st.nextToken().charAt(0);
        }

        grid[r][c] = dice[1];

        for (int i = 0; i < M; i++) {
            int[] direction = getDir(dir[i]);
            int nx = r + direction[0];
            int ny = c + direction[1];

            if (inRange(nx, ny)) {
                resetDice(dir[i]);

                grid[nx][ny] = dice[1];

                r = nx;
                c = ny;
            }
        }

        int sum = 0;
        for (int[] arr : grid) {
            for (int i : arr) {
                sum += i;
            }
        }

        System.out.println(sum);
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static int[] getDir(char dir) {
        if (dir == 'L') return new int[] {dx[0], dy[0]};
        if (dir == 'R') return new int[] {dx[1], dy[1]};
        if (dir == 'U') return new int[] {dx[2], dy[2]};
        if (dir == 'D') return new int[] {dx[3], dy[3]};
        return null;
    }

    public static void resetDice(char dir) {
        // 위 아래 앞 뒤  좌 우
        // 0  1  2  3  4  5 

        if (dir == 'L') {
            // 앞면 뒷면 고정 //
            // 위 -> 좌 -> 아래 -> 우 -> 위
            // 0 -> 4 -> 1 -> 5 -> 0
            int temp = dice[0];
            dice[0] = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[4];
            dice[4] = temp;
        }
        else if (dir == 'R') {
            // 앞면 뒷면 고정 //
            // 위 -> 우 -> 아래 -> 좌 -> 위
            // 0 -> 5 -> 1 -> 4 -> 0
            int temp = dice[0];
            dice[0] = dice[4];
            dice[4] = dice[1];
            dice[1] = dice[5];
            dice[5] = temp;
        }
        else if (dir == 'U') {
            // 좌측면 우측면 고정 //
            // 위 -> 뒷 -> 아래 -> 앞 -> 위
            // 0 -> 3 -> 1 -> 2 -> 0
            int temp = dice[0];
            dice[0] = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[3];
            dice[3] = temp;
        }
        else if (dir == 'D') {
            // 좌측면 우측면 고정 //
            // 위 -> 앞 -> 아래 -> 뒷 -> 위
            // 0 -> 2 -> 1 -> 3 -> 0
            int temp = dice[0];
            dice[0] = dice[3];
            dice[3] = dice[1];
            dice[1] = dice[2];
            dice[2] = temp;
        }
    }
}
 