import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] xy = new int[N][2];
        int[] check = new int[200_001];
        int[] prefix = new int[200_001];

        int maxX2 = 0;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            xy[i][0] = Integer.parseInt(st.nextToken());
            xy[i][1] = Integer.parseInt(st.nextToken());
            check[xy[i][0]] = 1;
            check[xy[i][1]] = -1;
            maxX2 = Math.max(maxX2, xy[i][1]);
        }

        int ans = 0;

        for (int i = 1; i <= maxX2; i++) {
            prefix[i] = prefix[i - 1] + check[i];
            ans = Math.max(ans, prefix[i]);
        }


        System.out.println(ans);
    }
}
 