import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < N ; i++) {
            int piv = i;
            int sum = 0;
            for (int j = 0; j < N ; j++) {
                sum += Math.abs(piv - j) * arr[j];
            }
            minValue = Math.min(sum, minValue);
        }

        System.out.println(minValue);
    }
}