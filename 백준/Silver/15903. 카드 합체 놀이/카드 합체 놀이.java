
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num = 0;
        while (num++ != M) {
            Arrays.sort(arr);
            long tmp = arr[0] + arr[1];
            arr[0] = tmp;
            arr[1] = tmp;
        }

        System.out.println(Arrays.stream(arr).sum());
    }
}
