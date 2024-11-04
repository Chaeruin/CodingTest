import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> a;
    static boolean[] visited;
    static int ans = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int findX = Integer.parseInt(st.nextToken());
        int findY = Integer.parseInt(st.nextToken());

        a = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }

        int M = Integer.parseInt(br.readLine());
        // 양방향 인접리스트 구현.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            a.get(x).add(y);
            a.get(y).add(x);
        }

        visited = new boolean[N + 1];
        DFS(findX, findY, 0);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // DFS를 이용하여 촌수 계산.
    public static void DFS(int pos, int find, int cnt) {
        visited[pos] = true;

        for (int i : a.get(pos)) {
            if (!visited[i]) {
                if (i == find) { // 찾으려는 사람의 도달.
                    ans = cnt + 1;
                    return;
                }

                DFS(i, find, cnt + 1);
            }
        }
    }
}
