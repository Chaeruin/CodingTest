import java.io.*;
import java.util.*;

public class Main {

    public static int N, answer;
    public static int[] operator = {-1, 1, 2, 3};
    public static boolean[] visited;

    // -1
    // +1
    // if (cur % 2 == 0), /2
    // if (cur % 3 == 0), /3

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        visited = new boolean[1_000_001];

        bfs();
        
        System.out.println(answer);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        // {currentNumber, count}
        queue.add(new int[] {N, 0});
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == 1) {
                answer = cur[1];
                return;
            }

            for (int i = 0; i < 4; i++) {
                int next = -1;
                if (i <= 1 && inRange(cur[0] + operator[i])) 
                    next = cur[0] + operator[i];
                else if (i > 1 && cur[0] % operator[i] == 0 && inRange(cur[0] / operator[i])) 
                    next = cur[0] / operator[i];
                
                if(next != -1 && !visited[next]){
                    visited[next] = true;
                    queue.add(new int[] {next, cur[1] + 1});
                }
            }
        }

    }

    public static boolean inRange(int x) {
        return x >= 1 && x <= 1_000_000;
    }
}
 