import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];

        dfs(0, 1);
    }

    public static void dfs(int depth, int start) {
        if (depth == M) {
            printAnswer();
            return;
        }

        for(int i = start; i <= N; i++){

            selected[depth] = i;

            dfs(depth + 1, i + 1);
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
 