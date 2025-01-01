
import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];

        bfs();
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {N, 0});
        visit[N] = true;

        while(!q.isEmpty()){
            int p[] = q.poll();
            if(p[0] == K){
                System.out.println(p[1]);
                return;
            }
            for(int i = 0; i < 3; i++){
                int next;
                if(i == 0) {
                    next = p[0] - 1;
                }
                else if(i == 1){
                    next = p[0] + 1;
                }
                else {
                    next = p[0] * 2;
                }

                if(0 <= next && next <= 100000 && !visit[next]){
                    q.add(new int[] {next, p[1] + 1});
                    visit[next] = true;
                }
            }
        }
    }
}
