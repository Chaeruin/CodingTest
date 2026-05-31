import java.io.*;
import java.util.*;

public class Main {
    static int N, H, T;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= N - T; i++) {
            int sum = 0;
            for (int j = i; j < i + T; j++) {
                sum += Math.abs(H - arr[j]);
            }

            min = Math.min(min, sum);
        }

        System.out.print(min);
    }
}



