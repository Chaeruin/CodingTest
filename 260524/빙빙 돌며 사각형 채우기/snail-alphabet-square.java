import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        int x = 0, y = 0;
        int num = 65;
        char ch = (char) num;
        arr[x][y] = ch;
        int dirNum = 0;
        int count = 0;
        
        while (count < N * M - 1) {
            int nx = x + dx[dirNum], ny = y + dy[dirNum];

            if (!inRange(nx, ny) || !(arr[nx][ny] == '\u0000'))
                dirNum = (dirNum + 1) % 4;
            
            x += dx[dirNum]; y += dy[dirNum];

            arr[x][y] = (char) (++num);

            if (num == 90) num = 64;

            count++;
        }

        for (char[] charArr : arr) {
            for (char chr : charArr) {
                sb.append(chr).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static boolean inRange(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }
}