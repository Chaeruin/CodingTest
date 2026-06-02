import java.io.*;
import java.util.*;

public class Main {

    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100;
    public static final int MAX_NUM = 40000;

    public static int N;
    public static int[] x = new int[MAX_N];
    public static int[] y = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int ans = INT_MAX;

        for (int i = 0; i < N; i++) {
            int minX = MAX_NUM, maxX = 1;
            int minY = MAX_NUM, maxY = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                minX = Math.min(minX, x[j]);
                maxX = Math.max(maxX, x[j]);
                minY = Math.min(minY, y[j]);
                maxY = Math.max(maxY, y[j]);
            }

            ans = Math.min(ans, (maxX - minX) * (maxY - minY));
        }

        System.out.println(ans);
    }
}



