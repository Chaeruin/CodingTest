import java.io.*;
import java.util.*;

public class Main {

    // 1번 :: 위 위위 아래 아아 0 ~ 3
    // 2번 :: 상 하 좌 우 4 ~ 7
    // 3번 :: 좌상 우상 좌하 우하 8 ~ 11
    public static int[] dx = {-1, -2, 1, 2, -1, 1, 0, 0, -1, -1, 1, 1};
    public static int[] dy = {0, 0, 0, 0, 0, 0, -1, 1, -1, 1, -1, 1};
    
    public static int N;
    public static List<int[]> bombs = new ArrayList<>();
    public static int[][] grid;
    public static boolean[][] visited;
    public static int count, answer;
    public static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) bombs.add(new int[] {i, j});
            }
        }

        count = bombs.size();
        selected = new int[count];

        answer = 0;

        bombing(0);

        System.out.println(answer);
    }

    public static void bombing(int idx) {
        if(idx == count){
            visited = new boolean[N][N];

            for(int i = 0; i < bombs.size(); i++){
                int[] bombIndex = bombs.get(i);
                int[] typeIndex = getTypeIndex(selected[i]);

                visited[bombIndex[0]][bombIndex[1]] = true;

                for (int l = 0; l < 4; l++) {
                    int nx = bombIndex[0] + dx[typeIndex[l]];
                    int ny = bombIndex[1] + dy[typeIndex[l]];

                    if (inRange(nx, ny)) visited[nx][ny] = true;
                }
            }

            int cnt = getVisitedCount();
            answer = Math.max(answer, cnt);
            return;
        }

        for(int type = 1; type <= 3; type++){

            selected[idx] = type;

            bombing(idx + 1);
        }
    }

    public static int getVisitedCount() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) cnt++;
            }
        }
        return cnt;
    }

    public static int[] getTypeIndex(int type) {
        if (type == 1) return new int[] {0, 1, 2, 3};
        else if (type == 2) return new int[] {4, 5, 6, 7};
        else if (type == 3) return new int[] {8, 9, 10, 11};

        return null;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
 