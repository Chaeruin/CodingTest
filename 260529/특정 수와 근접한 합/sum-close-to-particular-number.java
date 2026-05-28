import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int min = Integer.MAX_VALUE;
        int calc = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                calc = S - (totalSum - (arr[i] + arr[j]));
                min = Math.min(min, Math.abs(calc));
            }
        }

        System.out.print(min);
    }
}



