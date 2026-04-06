import java.io.*;
import java.util.*;

public class Main {
    static int N, K, count = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100_001];

        bfs(N, K);

        System.out.println(count);

    }

    static void bfs(int n, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {n, 0});
        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int c = cur[1];

            if (pos == k) {
                count = c;
                return;
            }

            int[] direction = {pos + 1, pos - 1, pos * 2};
            for (int d : direction) {
                if (d >= 0 && d < 100001 && !visited[d]) {
                    queue.add(new int[] {d, c + 1});
                    visited[d] = true;
                }
            }
        }
    }
}
