import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] arr;
    static boolean[] check;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        check = new boolean[N];
        Arrays.fill(check, false);

        tracking(0);

    }

    static void tracking(int depth) {
        if (depth == M) {
            for(int val: arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                arr[depth] = i+1;
                tracking(depth + 1);
                check[i] = false;
            }
        }
    }
}
