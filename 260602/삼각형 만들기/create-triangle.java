import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] x;
    static int[] y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        x = new int[N];
        y = new int[N];
        
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        
        int maxArea = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (i == j || j == k || k == i) continue;
                    if (isParallelH(i, j) && isParallelW(j, k)) {
                        int currentH = Math.abs(y[i] - y[j]);
                        int currentW = Math.abs(x[j] - x[k]);
                        
                        int currentArea = currentH * currentW;
                        
                        maxArea = Math.max(maxArea, currentArea);
                    }
                }
            }
        }

        System.out.println(maxArea);
    }

    static boolean isParallelH(int i, int j) {
        return x[i] == x[j];
    }

    static boolean isParallelW(int j, int k) {
        return y[j] == y[k];
    }
}



