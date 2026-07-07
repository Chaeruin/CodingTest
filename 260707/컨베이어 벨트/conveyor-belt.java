import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] u = new int[N];
        int[] d = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            u[j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            d[j] = Integer.parseInt(st.nextToken());
        }
        

        while(T-- > 0) {
            int temp = u[N - 1];

            for(int i = N - 1; i >= 1; i--)
                u[i] = u[i - 1];
            u[0] = d[N - 1];

            for(int i = N - 1; i >= 1; i--)
                d[i] = d[i - 1];
            d[0] = temp;
        }

        for (int un : u) {
            System.out.print(un + " ");
        }
        System.out.println();

        for (int un : d) {
            System.out.print(un + " ");
        }
        System.out.println();

    }
}
 