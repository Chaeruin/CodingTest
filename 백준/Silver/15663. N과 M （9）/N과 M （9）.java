
import java.io.*;
import java.util.*;

class Main {
    static int M, N;
    static int[] set;
    static int[] output;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        set = new int[N];
        output = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(set);

        dfs(0);
    }

    static void dfs(int cnt){
        if (cnt == M) {
            for(int i = 0; i < M; i++)
                System.out.print(output[i]+" ");
            System.out.println();
        }

        else {
            int before = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i])
                    continue;

                if (before != set[i]) {
                    visited[i] = true;
                    output[cnt] = set[i];
                    before = set[i];
                    dfs(cnt + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
