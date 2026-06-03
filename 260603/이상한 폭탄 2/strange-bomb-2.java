import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] bomb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bomb = new int[N];

        for (int i = 0; i < N; i++) {
            bomb[i] = Integer.parseInt(br.readLine());
        }

        int maxNum = 0;

        for (int i = 0; i < N; i++) {
            int pivBomb = bomb[i];
            int tmp = 0;
            for (int j = i + 1; j <= i + K && j < N; j++) {
                if (bomb[j] == pivBomb) {
                    tmp = pivBomb;
                    // System.out.println(tmp);
                }
            }

            maxNum = Math.max(maxNum, tmp);
        }

        if (maxNum == 0) System.out.println(-1);
        else System.out.println(maxNum);
    }
}



