import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 1; i < N - 1; i++) {
            int pass = i;
            int sumDistance = 0;
            int startX = arr[0][0], startY = arr[0][1];
            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                sumDistance += (Math.abs(startX - arr[j][0]) + Math.abs(startY - arr[j][1]));
                startX = arr[j][0];
                startY = arr[j][1];
            }
            minDistance = Math.min(minDistance, sumDistance);
        }

        System.out.println(minDistance);
    }
}