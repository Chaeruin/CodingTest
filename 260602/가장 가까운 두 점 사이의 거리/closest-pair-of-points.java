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

        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++)
            for(int j = i + 1; j < N; j++)
                minDist = Math.min(minDist, dist(i, j));

        System.out.println(minDist);
    }

    public static int dist(int i, int j) {
        return (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
    }
}



