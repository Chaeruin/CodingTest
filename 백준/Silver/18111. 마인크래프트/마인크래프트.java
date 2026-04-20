
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, B;
    static int[] result = new int[2];
    static int[][] arr;
    static int time = Integer.MAX_VALUE;
    static int height;
    static int block;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arr = new int [N][M];
        int max = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                max = Math.max(max, arr[i][j]);
            }
        }

        bruteForce(max);

        System.out.println(time + " " + height);

    }

    static void bruteForce(int max) {

        for(int i = 0; i <= max; i++) {
            result = excavation(i);

            if (time > result[0]) {
                time = result[0];
                height = result[1];
            } else if(time == result[0] && height < result[1]) {
                time = result[0];
                height = result[1];
            }

        }
    }

    static int[] excavation(int height) {
        int block = B;
        int time = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int value = arr[i][j];

                if (value == height) {
                    continue;
                } else if (value > height) {    // 블록 깎기
                    time += (value - height) * 2;
                    block += (value - height);
                }
                else {                          // 블록 쌓기
                    time += height - value;
                    block -= (height - value);
                }
            }
        }

        if (block < 0) {
            result[0] = 999999999;
            return result;
        }

        result[0] = time;
        result[1] = height;

        return result;
    }
}
