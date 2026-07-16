import java.util.*;

public class Main {
    // 위, 아래, 좌, 우
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int n, m, t;
    public static int[][] grid;

    // 구슬 객체를 정의해서 관리하면 충돌 소멸 처리가 매우 쉬워집니다.
    public static class Bead {
        int x, y;
        boolean isDead = false;

        public Bead(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static List<Bead> beads = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            beads.add(new Bead(r, c));
        }

        // t초 동안 시뮬레이션 진행
        for (int i = 0; i < t; i++) {
            simulateOneSecond();
        }

        // 남은 구슬의 개수 출력
        System.out.println(beads.size());
    }

    public static void simulateOneSecond() {
        // 1. 구슬들이 동시에 도달할 임시 격자판 (구슬 개수를 기록)
        int[][] nextGrid = new int[n][n];

        // 2. 모든 구슬을 "동시에" 한 칸 이동시킴
        for (Bead b : beads) {
            int maxDir = getMaxDir(b.x, b.y);
            b.x = b.x + dx[maxDir];
            b.y = b.y + dy[maxDir];
            nextGrid[b.x][b.y]++; // 이동한 위치에 구슬 개수 누적
        }

        // 3. 겹친 칸에 있는 구슬들을 사망 처리
        for (Bead b : beads) {
            if (nextGrid[b.x][b.y] > 1) {
                b.isDead = true;
            }
        }

        // 4. 살아남은 구슬들만 리스트에 남김
        List<Bead> aliveBeads = new ArrayList<>();
        for (Bead b : beads) {
            if (!b.isDead) {
                aliveBeads.add(b);
            }
        }
        beads = aliveBeads; // 다음 초를 위해 리스트 교체
    }

    public static int getMaxDir(int x, int y) {
        int maxValue = -1;
        int dir = -1;
        
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (inRange(nx, ny) && maxValue < grid[nx][ny]) {
                maxValue = grid[nx][ny];
                dir = d;
            }
        }
        return dir;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}