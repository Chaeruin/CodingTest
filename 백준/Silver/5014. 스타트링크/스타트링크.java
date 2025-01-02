
import java.io.*;
import java.util.*;

public class Main {

    static int F, S, G, U, D;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1];

        bfs();
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{S, 0});
        visited[S] = true;

        while(!queue.isEmpty()) {
            int p[] = queue.poll();
            if(p[0] == G){
                System.out.println(p[1]);
                return;
            }
            for(int i = 0; i < 2; i++){
                int next = -1;
                if(i == 0 && p[0] - D > 0) {
                    next = p[0] - D;
                }
                else if(i == 1 && p[0] + U <= F){
                    next = p[0] + U;
                }
                if(0 <= next && !visited[next]){
                    queue.add(new int[] {next, p[1] + 1});
                    visited[next] = true;
                }
            }
        }
        System.out.println("use the stairs");
        return;
    }
}
