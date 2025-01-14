
import java.io.*;
import java.util.*;

public class Main {

    static int L, C;
    static String[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);

        dfs(0, 0);
    }

    static void dfs(int start, int count) {
        if (count == L) {
            String word = "";
            int a = 0;
            int b = 0;
            for (int i = 0; i < C; i++) {
                if (visited[i]) {
                    word += arr[i];
                    if (arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")) {
                        a++;
                    } else {
                        b++;
                    }
                }
            }
            if (a >= 1 && b >= 2) {
                System.out.println(word);
            }
        }

        for (int i = start; i < C; i++) {
            visited[i] = true;
            dfs(i + 1, count + 1);
            visited[i] = false;
        }
    }
}
