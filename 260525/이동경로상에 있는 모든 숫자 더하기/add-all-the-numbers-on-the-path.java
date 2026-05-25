import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static char[] command;
    static int N;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1}; // 북, 동, 남, 서  (상, 우, 하, 좌);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        command = new char[T];

        String str = br.readLine();
        for (int i = 0; i < T; i++) {
            command[i] = str.charAt(i);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = N / 2, y = N / 2;
        int sum = arr[x][y];
        int dirNum = 0;

        for (int i = 0; i < T; i++) {
            char cmd = command[i];

            if (cmd == 'R') dirNum = (dirNum + 1) % 4;
            if (cmd == 'L') dirNum = (dirNum - 1 + 4) % 4; // 상 -> 좌 / 우 -> 상 / 하-> 우 / 좌 -> 하
                                                        // 0 -> 3 / 1 -> 0 / 2 -> 1 / 3 -> 2
            if (cmd == 'F') {
                int nx = x + dx[dirNum], ny = y + dy[dirNum];
                if (!inRange(nx, ny)) continue;

                x += dx[dirNum];
                y += dy[dirNum];
                sum += arr[x][y];
            }
        }

        System.out.println(sum);

    }

    static boolean inRange(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }
}