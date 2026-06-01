import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr1 = new int[3];
    static int[] arr2 = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum1 = 0;
        int sum2 = 0;
        int duplication = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if ((Math.abs(i - arr1[0]) % (N - 2) <= 2)
                        && (Math.abs(j - arr1[1]) % (N - 2) <= 2)
                        && (Math.abs(k - arr1[2]) % (N - 2) <= 2)) {
                        // System.out.println(i + " " + j + " " + k);
                        sum1++;
                    }
                }
            }
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if ((Math.abs(i - arr2[0]) % (N - 2) <= 2)
                        && (Math.abs(j - arr2[1]) % (N - 2) <= 2)
                        && (Math.abs(k - arr2[2]) % (N - 2) <= 2)) {
                        sum2++;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if ((Math.abs(i - arr1[0]) % (N - 2) <= 2)
                        && (Math.abs(j - arr1[1]) % (N - 2) <= 2)
                        && (Math.abs(k - arr1[2]) % (N - 2) <= 2)
                        && (Math.abs(i - arr2[0]) % (N - 2) <= 2)
                        && (Math.abs(j - arr2[1]) % (N - 2) <= 2)
                        && (Math.abs(k - arr2[2]) % (N - 2) <= 2)) {
                        duplication++;
                    }
                }
            }
        }

        System.out.println(sum1 + sum2 - duplication);
    }
}



