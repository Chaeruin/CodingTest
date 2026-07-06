import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxCoin = Integer.MIN_VALUE;

        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= N - 3; j++) {
                int count = 0;

                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (arr[k][l] == 1) count++;
                    }
                }

                maxCoin = Math.max(maxCoin, count);
            }
        }

        System.out.println(maxCoin);
    }
}
