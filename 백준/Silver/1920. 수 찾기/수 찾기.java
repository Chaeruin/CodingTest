import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.parallelSort(A);

        for (int i = 0; i < M; i++) {
            if (Arrays.binarySearch(A, B[i]) >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
