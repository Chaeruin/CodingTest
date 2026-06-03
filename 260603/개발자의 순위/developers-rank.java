import java.io.*;
import java.util.*;

public class Main {

    static int K, N;
    static int[][] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        rank = new int[K][N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                rank[i][Integer.parseInt(st.nextToken())] = j + 1;
            }
        }

        int ans = 0;

        for (int i = 1; i <= N; i++) {
            for (int k = 1; k <= N; k++) {
                if (i == k) continue;

                boolean isAlwaysBetter = true;

                for (int j = 0; j < K; j++) {
                    int rankA = rank[j][i];
                    int rankB = rank[j][k];

                    if (rankA >= rankB) {
                        isAlwaysBetter = false;
                        break;
                    }
                }

                if (isAlwaysBetter) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}



