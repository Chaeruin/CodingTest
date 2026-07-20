import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[] arr;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    public static void dfs(int idx, int cnt) {
        if (idx == N - 1) {
            answer = Math.min(answer, cnt);
            return;
        }

        int jumpAvailable = arr[idx];

        for (int i = 1; i <= jumpAvailable; i++) {
            if (idx + i < N) {
                dfs(idx + i, cnt + 1);
            }
        }
    }

    
}
 