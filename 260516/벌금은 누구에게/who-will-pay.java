import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int idx = Integer.parseInt(br.readLine());
            arr[idx]++;

            if (arr[idx] >= K) {
                System.out.println(idx);
                break;
            }
        }
        int not = notOverK(arr, N, K);
        if (not == -1) System.out.println(not);
        
    }

    static int notOverK(int[] arr, int N, int K) {
        for (int i = 1; i <= N; i++) {
            if (arr[i] >= K) return i;
        }
        return -1;
    }
}