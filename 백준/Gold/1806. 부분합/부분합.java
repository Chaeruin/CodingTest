
import java.util.*;
import java.io.*;

public class Main {

    static int N, S;
    static int[] arr;
    static int start = 0, end = 0;
    static int sum = 0;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        while (true) {
            if (S <= sum) {
                sum -= arr[start];
                result = Math.min(result, end - start);
                start++;
            } else if (end == N) {
                break;
            } else {
                sum += arr[end++];
            }
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
