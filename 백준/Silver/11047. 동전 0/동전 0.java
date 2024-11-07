import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] coin = new int[N];

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int n = N - 1;
        int count = 0;

        while (K != 0 && n >= 0) {
            if (K - coin[n] >= 0) {
                K -= coin[n];
                count++;
            } else {
                n--;
            }
        }

        System.out.println(count);
    }
}