import java.io.*;
import java.util.*;

public class Main {

    public static List<Integer>[][] list;
    public static int[][] index;
    public static int N, M;
    // 상 하 좌 우 좌상 우상 좌하 우하
    public static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    public static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = (List<Integer>[][]) new List[N][N];
        index = new int[N * N + 1][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                List<Integer> temp = new ArrayList<>();
                int input = Integer.parseInt(st.nextToken());
                temp.add(input);
                list[i][j] = temp;
                index[input][0] = i;
                index[input][1] = j;
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int turn = Integer.parseInt(st.nextToken());
            int dir = getMaxDir(turn);

            moveNumber(turn, dir);
        }

        for (List<Integer>[] arr : list) {
            for (List<Integer> l : arr) {
                if (l.isEmpty()) System.out.println("None");
                else {
                    for (Integer i : l) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void moveNumber(int turn, int dir) {
        int x = index[turn][0];
        int y = index[turn][1];

        if (dir == -1) return;

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        List<Integer> currentList = list[x][y];
    
        int targetIdx = currentList.indexOf(turn);
        
        List<Integer> movingMarbles = new ArrayList<>();
        for (int i = 0; i <= targetIdx; i++) {
            movingMarbles.add(currentList.get(i));
        }
        
        for (int i = 0; i <= targetIdx; i++) {
            currentList.remove(0);
        }

        list[nx][ny].addAll(0, movingMarbles);

        for (int i = 0; i < movingMarbles.size(); i++) {
            int marble = movingMarbles.get(i);
            index[marble][0] = nx;
            index[marble][1] = ny;
        }
    }

    public static int getMaxDir(int turn) {
        int x = index[turn][0];
        int y = index[turn][1];

        int maxValue = -1;
        int dir = -1;

        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (inRange(nx, ny) && list[nx][ny] != null) {
                for (int elm : list[nx][ny]) {
                    if (maxValue < elm) {
                        dir = d;
                        maxValue = elm;
                    }
                }
            }
        }

        return dir;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
 