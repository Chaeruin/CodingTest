import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        int x = 0, y = 0;
        int count = 1;
        int dirNum = 0;
        arr[x][y] = count;

        while (count < N * M) {
            int nx = x + dx[dirNum], ny = y + dy[dirNum];
            if (!inRange(nx, ny) || arr[nx][ny] != 0) 
                dirNum = (dirNum + 1) % 4;

            x += dx[dirNum]; y += dy[dirNum];
            arr[x][y] = ++count;
        }

        StringBuilder sb = new StringBuilder();

        for (int[] intArr : arr) {
            for (int i : intArr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < M);
    }


}