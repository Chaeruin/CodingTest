import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 1   2   3
        // 가위 주먹 보   -> 1 < 2 < 3 < 1
        // 가위 보  주먹  -> 1 < 3 < 2 < 1
        // 주먹 가위 보   -> 2 < 1 < 3 < 2
        // 주먹 보  가위  -> 3 < 1 < 2 < 3
        // 보  가위 주먹  -> 2 < 3 < 1 < 2
        // 보  주먹 가위  -> 3 < 2 < 1 < 3

        int first = winCountFirst();
        int second = winCountSecond();
        int third = winCountThird();
        int fourth = winCountFourth();
        int fifth = winCountFifth();
        int sixth = winCountSixth();

        int max = Integer.MIN_VALUE;

        max = Math.max(Math.max(Math.max(Math.max(Math.max(first, second), third), fourth), fifth), sixth);

        System.out.println(max);

    }

    // 가위 주먹 보   -> 1 < 2 < 3 < 1
    static int winCountFirst() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            int k = arr[i][0];
            int j = arr[i][1];

            if (k == 2 && j == 1) count++;
            if (k == 3 && j == 2) count++;
            if (k == 1 && j == 3) count++;
        }

        return count;
    }

    // 가위 보  주먹  -> 1 < 3 < 2 < 1
    static int winCountSecond() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            int k = arr[i][0];
            int j = arr[i][1];

            if (k == 3 && j == 1) count++;
            if (k == 2 && j == 3) count++;
            if (k == 1 && j == 2) count++;
        }

        return count;
    }

    // 주먹 가위 보   -> 2 < 1 < 3 < 2
    static int winCountThird() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            int k = arr[i][0];
            int j = arr[i][1];

            if (k == 1 && j == 2) count++;
            if (k == 3 && j == 1) count++;
            if (k == 2 && j == 3) count++;
        }

        return count;
    }

    // 주먹 보  가위  -> 3 < 1 < 2 < 3
    static int winCountFourth() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            int k = arr[i][0];
            int j = arr[i][1];

            if (k == 1 && j == 3) count++;
            if (k == 2 && j == 1) count++;
            if (k == 3 && j == 2) count++;
        }

        return count;
    }

    // 보  가위 주먹  -> 2 < 3 < 1 < 2
    static int winCountFifth() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            int k = arr[i][0];
            int j = arr[i][1];

            if (k == 3 && j == 2) count++;
            if (k == 1 && j == 3) count++;
            if (k == 2 && j == 1) count++;
        }

        return count;
    }

    // 보  주먹 가위  -> 3 < 2 < 1 < 3
    static int winCountSixth() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            int k = arr[i][0];
            int j = arr[i][1];

            if (k == 2 && j == 3) count++;
            if (k == 1 && j == 2) count++;
            if (k == 3 && j == 1) count++;
        }

        return count;
    }
}



