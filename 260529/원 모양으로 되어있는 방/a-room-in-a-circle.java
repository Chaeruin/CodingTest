import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int piv = arr[i];
            int sum = 0;
            for (int j = i; j < N + i; j++) {
                sum += (arr[j % N] * Math.abs(j - i));
            }

            min = Math.min(min, sum);
        }

        System.out.print(min);
    }
}



