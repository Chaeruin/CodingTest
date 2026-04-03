import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int smallest = Integer.MAX_VALUE;
        int a = 0, b = 0;

        int left = 0;
        int right = N - 1;
        int mid = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < smallest) {
                smallest = Math.abs(sum);
                a = arr[left];
                b = arr[right];
            }

            if (sum > 0) right--;
            else if (sum < 0) left++;
            else break;
        }

        System.out.println(a + " " + b);
    }
}
