import java.io.*;
import java.util.*;

public class Main {

    public static int N, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int len) {

        if (len == N) {
            answer++;
            return;
        }

        if (len > N) {
            return;
        }

        // 1
        dfs(len + 1);

        // 22
        dfs(len + 2);

        // 333
        dfs(len + 3);

        // 4444
        dfs(len + 4);
    }

}
 