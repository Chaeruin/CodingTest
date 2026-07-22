import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[] selected;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        selected = new int[N];

        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == N) {
            printAnswer();
            return;
        }

        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;

            selected[depth] = i + 1;

            dfs(depth + 1);

            visited[i]=false;
        }
    }

    public static void printAnswer() {
        StringBuilder sb = new StringBuilder();
        for (int i : selected) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
 