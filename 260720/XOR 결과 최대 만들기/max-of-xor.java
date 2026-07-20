import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[] arr;
    public static int[] selected;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int depth, int start) {
        if(depth == M) {
            answer = Math.max(answer, calculate());
            return;
        }
            

        for(int i = start; i < N; i++){

            selected[depth] = arr[i];

            dfs(depth + 1, i + 1);
        }
    }

    public static int calculate() {
        int xor = 0;

        for (int i : selected) {
            xor ^= i;
        }

        return xor;
    }
}
 