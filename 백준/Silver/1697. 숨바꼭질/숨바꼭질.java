import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visit;
    static int N, K;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];

        bfs(N, K);

        System.out.println(result);

    }

    public static void bfs(int start, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {start, 0});
        visit[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int count = cur[1];

            if (pos == target) {
                result = count;
                return;
            }

            int[] direction = {pos + 1, pos - 1, pos * 2};
            for (int d : direction) {
                if (d >= 0 && d < 100001 && !visit[d]) {
                    queue.add(new int[] {d, count + 1});
                    visit[d] = true;
                }
            }
        }
    }
}