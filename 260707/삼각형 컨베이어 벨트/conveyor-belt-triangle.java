import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] left = new int[N];
        int[] right = new int[N];
        int[] under = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            left[j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            right[j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            under[j] = Integer.parseInt(st.nextToken());
        }
        

        while(T-- > 0) {
            int temp1 = left[N - 1];

            for(int i = N - 1; i >= 1; i--)
                left[i] = left[i - 1];
            left[0] = under[N - 1];

            int temp2 = right[N - 1];

            for(int i = N - 1; i >= 1; i--)
                right[i] = right[i - 1];
            right[0] = temp1;

            for(int i = N - 1; i >= 1; i--)
                under[i] = under[i - 1];
            under[0] = temp2;
        }

        for (int i : left) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : right) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : under) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
 