
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int keyword = Integer.parseInt(st.nextToken());
            if (keyword == 1) {
                int in = Integer.parseInt(st.nextToken());
                deque.addFirst(in);
            } else if (keyword == 2) {
                int in = Integer.parseInt(st.nextToken());
                deque.addLast(in);
            } else if (keyword == 3) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.pollFirst()).append("\n");
            } else if (keyword == 4) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.pollLast()).append("\n");
            } else if (keyword == 5) {
                sb.append(deque.size()).append("\n");
            } else if (keyword == 6) {
                if (deque.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (keyword == 7) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.peekFirst()).append("\n");
            } else if (keyword == 8) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.peekLast()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
