import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        int dirNum = 0;
        int x = N - 1, y = N - 1;
        int count = N * N;
        arr[x][y] = count;

        while (count > 1) {
            int nx = x + dx[dirNum], ny = y + dy[dirNum];

            if (!inRange(nx, ny) || arr[nx][ny] != 0) 
                dirNum = (dirNum + 1) % 4;
            
            x += dx[dirNum];
            y += dy[dirNum];

            arr[x][y] = --count;
        }

        for (int[] intArr : arr) {
            for (int i : intArr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static boolean inRange(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }
}