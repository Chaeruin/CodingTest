
import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1}; // 기존 좌표 기준 상, 우, 하, 좌
    static int[] dy = {1, 0, -1, 0};
    static int minNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        minNum = Math.min(N, M);

        for (int i = 1; i <= R; i++) {
            rotate();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
    static void rotate() {
        for(int t = 0; t < minNum/2; t++) {
            int x = t;
            int y = t;

            int temp = arr[x][y];

            int idx = 0;
            while(idx < 4) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                if(nx < arr.length - t && ny < arr[0].length - t && nx >= t && ny >= t) {
                    arr[x][y] = arr[nx][ny];
                    x = nx;
                    y = ny;
                }
                else {
                    idx++;
                }
            }

            arr[t + 1][t] = temp;
        }
    }
}
