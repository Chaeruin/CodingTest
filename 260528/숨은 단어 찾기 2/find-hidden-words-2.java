import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] arr;

    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
    // 상 하 좌 우 우상 우하 좌상 좌하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int word = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'L') {
                    for (int dir = 0; dir < 8; dir++) {
                        int count = 0;

                        for (int step = 1; step <= 2; step++) {
                            int nx = i + dx[dir] * step;
                            int ny = j + dy[dir] * step;

                            if (inRange(nx, ny) && arr[nx][ny] == 'E') count++;
                            else break;
                        }

                        if (count == 2) {
                            word++;
                        }
                    }
                }
                
            }
        }

        System.out.println(word);
    }

    static boolean inRange(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }
}