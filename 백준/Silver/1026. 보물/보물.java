
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static Integer[] A, B;

    public static void main(String[]_args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new Integer[N];
        B = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] copyB = B.clone();
        Arrays.sort(copyB, Collections.reverseOrder());
        Arrays.sort(A);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i] * copyB[i];
        }

        System.out.println(sum);
    }
}
