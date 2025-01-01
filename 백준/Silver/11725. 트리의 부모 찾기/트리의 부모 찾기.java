import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] parent;
    static boolean[] visited;
    static ArrayList<Integer>[] nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        nodeList = new ArrayList[N+1];
        parent = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            nodeList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodeList[a].add(b);
            nodeList[b].add(a);
        }

         dfs(1);
        // bfs();

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    // 1번 - dfs 방법
    static void dfs(int idx) {
        visited[idx] = true;
        for (int i: nodeList[idx]) {
            if(!visited[i]) {
                parent[i] = idx;
                dfs(i);
            }
        }
    }

    // 2번 - bfs 방법
    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        // BFS
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i : nodeList[cur]) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                queue.add(i);
                parent[i] = cur;
            }
        }
    }


}
