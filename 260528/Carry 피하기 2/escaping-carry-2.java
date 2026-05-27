import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (!isCarry(arr[i], arr[j], arr[k]))
                        sum = Math.max(sum, arr[i] + arr[j] + arr[k]);
                }
            }
        }

        if (sum == 0) System.out.print(-1);
        else System.out.print(sum);
    }

    static boolean isCarry(int a, int b, int c) {
        while (a > 0 || b > 0 || c > 0) {
            int sum = (a % 10) + (b % 10) + (c % 10);

            if (sum >= 10) {
                return true;
            }

            a /= 10;
            b /= 10;
            c /= 10;
        }

        return false;
    }
}