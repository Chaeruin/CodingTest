import java.io.*;
import java.util.*;

public class Main {
    public static int K, N;
    static int[] selected;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        selected = new int[N];

        duplicatePerm(0);

        System.out.print(sb);
    }

    static void duplicatePerm(int depth) {

        if (depth == N) {
            for (int i : selected) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= K; i++) {
            selected[depth] = i;
            duplicatePerm(depth + 1);
        }
    }
}
 