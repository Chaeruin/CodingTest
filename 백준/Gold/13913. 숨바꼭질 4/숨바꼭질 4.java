import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited = new boolean[100001];
    static int[] dx = {-1, 1};
    static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        if (n == k) {
            System.out.println(0);
            System.out.println(n);
        } else {
            bfs(n, k);
            StringBuilder sb = new StringBuilder();
            Stack<Integer> stack = new Stack<>();
            int after = k;
            while (after != n) {
                stack.push(after);
                after = arr[after];
            }
            stack.push(n);

            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }

            System.out.println(sb);

        }

    }

    static void bfs(int start, int destination) {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[100_001];
        q.add(new int[]{start, 0});
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] p = q.poll();
            int pos = p[0];
            int move = p[1];
            if(pos == destination) {
                System.out.println(move);
                return;
            }
            int jump = pos * 2;
            if(jump < 100001 && !visited[jump]) {
                visited[jump] = true;
                q.add(new int[]{jump, move + 1});
                arr[jump] = pos;
            }

            for(int i = 0; i < 2; i++) {
                int next = pos + dx[i];
                if (next >= 0 && next < 100001 && !visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, move + 1});
                    arr[next] = pos;
                }
            }
        }
    }
}