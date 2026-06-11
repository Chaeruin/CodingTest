import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {

            int minX = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;

            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                minX = Math.min(minX, arr[j][0]);
                maxX = Math.max(maxX, arr[j][1]);
            }

            int length = maxX - minX;
            minLength = Math.min(minLength, length);
        }

        System.out.println(minLength);
    }
}
