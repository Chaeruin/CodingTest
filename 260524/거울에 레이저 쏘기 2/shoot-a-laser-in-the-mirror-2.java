import java.io.*;
import java.util.*;

public class Main {

    static String[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new String[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().split("");
        }

        int K = Integer.parseInt(br.readLine());

        int didx = calcIndex(K);
        int[] idx = startIndex(K);

        int count = 0;

        while (idx[0] >= 0 && idx[0] < N && idx[1] >= 0 && idx[1] < N) {

            didx = calcDidx(idx[0], idx[1], didx);

            idx[0] += dx[didx];
            idx[1] += dy[didx];

            count++;
        }

        System.out.println(count);
    }

    static int calcDidx(int x, int y, int didx) {
        if (arr[x][y].equals("/") && didx == 0) return 1;
        if (arr[x][y].equals("/") && didx == 1) return 0;
        if (arr[x][y].equals("/") && didx == 2) return 3;
        if (arr[x][y].equals("/") && didx == 3) return 2;
        if (arr[x][y].equals("\\") && didx == 0) return 3;
        if (arr[x][y].equals("\\") && didx == 1) return 2;
        if (arr[x][y].equals("\\") && didx == 2) return 1;
        if (arr[x][y].equals("\\") && didx == 3) return 0;
        return -1;
    }

    static int calcIndex(int K) {
        return (K - 1) / N;
    }

    static int[] startIndex(int K) {
        int offset = (K - 1) % N;
        int side = (K - 1) / N;

        if (side == 0) return new int[]{0, offset};
        else if (side == 1) return new int[]{offset, N - 1};
        else if (side == 2) return new int[]{N - 1, N - 1 - offset};
        else return new int[]{N - 1 - offset, 0};
    }
}