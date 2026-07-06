import java.io.*;
import java.util.*;

public class Main {
    public static int[][][] shapes = new int[][][]{
        {{1, 1, 0}, {1, 0, 0}, {0, 0, 0}},
        {{1, 1, 0}, {0, 1, 0}, {0, 0, 0}},
        {{1, 0, 0}, {1, 1, 0}, {0, 0, 0}},
        {{0, 1, 0}, {1, 1, 0}, {0, 0, 0}},
        {{1, 1, 1}, {0, 0, 0}, {0, 0, 0}},
        {{1, 0, 0}, {1, 0, 0}, {1, 0, 0}},
    };
    public static int[][] arr;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer = Math.max(answer, getMaxSum(i, j));
            }
        }

        System.out.println(answer);

    }

    public static int getMaxSum(int x, int y) {
        int maxSum = 0;
        
        for(int i = 0; i < 6; i++) {
            boolean isPossible = true;
            int sum = 0;

            for(int dx = 0; dx < 3; dx++)
                for(int dy = 0; dy < 3; dy++) {
                    if(shapes[i][dx][dy] == 0) continue;
                    if(x + dx >= N || y + dy >= M) isPossible = false;
                    else sum += arr[x + dx][y + dy];
                }
    
            if(isPossible)
                maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
}
