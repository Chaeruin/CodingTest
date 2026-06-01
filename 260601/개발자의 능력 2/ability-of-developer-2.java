import java.io.*;
import java.util.*;

public class Main {

    static int[] arr = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (k == i || k == j) continue;
                    for (int l = k + 1; l < 6; l++) {
                        if (l == i || l == j) continue;
                        int diff = getDiff(i, j, k, l);
                        // System.out.println(i + " " + j + " " + k + " " + l);
                        minDiff = Math.min(minDiff, diff);
                    }
                }
            }
        }

        System.out.print(minDiff);
    }

    static int getDiff(int i, int j, int k, int l) {
        int sum1 = arr[i] + arr[j];
        int sum2 = arr[k] + arr[l];
        int sum3 = 0;

        for (int m = 0; m < 6; m++) {
            sum3 += arr[m];
        }
        sum3 -= (sum1 + sum2);

        int max = Math.max(sum1, Math.max(sum2, sum3));
        int min = Math.min(sum1, Math.min(sum2, sum3));

        return max - min;
    }
}



