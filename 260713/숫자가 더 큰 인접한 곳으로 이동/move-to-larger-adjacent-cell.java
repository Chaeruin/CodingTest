import java.util.Scanner;
public class Main {

    public static int N, r, c;
    public static int[][] grid;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(grid[r][c]).append(" ");

        while (isNotEnd()) {
            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];

                if (inRange(nx, ny)) {
                    if (grid[r][c] < grid[nx][ny]) {
                        r = nx;
                        c = ny;
                        sb.append(grid[r][c]).append(" ");
                        break;
                    }
                }
            }
        }
        
        System.out.println(sb);

    }

    public static boolean isNotEnd() {
        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (inRange(nx, ny)) {
                if (grid[r][c] < grid[nx][ny]) return true;
            }
        }
        return false;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}