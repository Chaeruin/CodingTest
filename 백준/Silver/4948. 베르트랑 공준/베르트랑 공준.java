
import java.io.*;
import java.util.*;

class Main {
    static int[] arr1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        while (N != 0) {
            arr1 = new int[2 * N + 1];
            eratosthenesSieve(N);

            int count = 0;
            for (int i = N + 1; i <= 2 * N; i++) {
                if (arr1[i] != 0) count++;
            }

            System.out.println(count);

            N = Integer.parseInt(br.readLine());
        }
    }

    static void eratosthenesSieve(int N) {
        for (int i = 2; i <= 2 * N; i++) {
            arr1[i] = i;
        }

        for (int i = 2; i <= 2 * N; i++) {
            if (arr1[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= 2 * N; j += i) {
                arr1[j] = 0;
            }
        }
    }


}
