
import java.io.*;
import java.util.*;

public class Main {

    static long[] f;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        f = new long[N + 1];
        System.out.println(pinary());
    }

    static long pinary() {
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 1;
        }

        f[1] = 1; f[2] = 1;

        for (int i = 3; i <= N; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[N];
    }
}
