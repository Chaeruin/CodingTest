
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int count;
    static boolean[] visited;
    static List[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new List[N+1];
        visited = new boolean[N+1];

        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start].add(end);
            arr[end].add(start);
        }

        count = 0;
        bfs(1);
        System.out.println(count-1);
        br.close();
    }

    static void bfs(int start) {
        Queue queue = new LinkedList<Integer>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int now = (int) queue.poll();
            if (!visited[now]) {
                count++;
                visited[now] = true;
                for (int i = 0; i < arr[now].size(); i++) {
                    queue.add(arr[now].get(i));
                }
            }
        }
    }

}