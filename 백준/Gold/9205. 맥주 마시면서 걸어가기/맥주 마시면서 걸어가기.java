
import java.io.*;
import java.util.*;

public class Main {

    static int T, N;
    static int[][] xy;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            xy = new int[N + 2][2];
            visited = new boolean[N + 2];

            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                xy[i][0] = Integer.parseInt(st.nextToken());
                xy[i][1] = Integer.parseInt(st.nextToken());
            }

            bfs(0);

            if (visited[N + 1]) System.out.println("happy");
            else System.out.println("sad");

        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for (int next = 0; next < N + 2; next++) {
                if (!visited[next]) {
                    int distance = Math.abs(xy[current][0] - xy[next][0]) + Math.abs(xy[current][1] - xy[next][1]);
                    if (distance <= 1000) { // 맥주 20병(1000m) 이내에 도달 가능
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
    }
}
