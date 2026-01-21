
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String keyword = st.nextToken();
            if (keyword.equals("push")) {
                int in = Integer.parseInt(st.nextToken());
                queue.add(in);
            } else if (keyword.equals("pop")) {
                if (queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.poll()).append("\n");
            } else if (keyword.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (keyword.equals("empty")) {
                if (queue.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (keyword.equals("front")) {
                if (queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.peek()).append("\n");
            } else if (keyword.equals("back")) {
                if (queue.isEmpty()) sb.append(-1).append("\n");
                else {
                    int last = ((LinkedList<Integer>) queue).getLast();
                    sb.append(last).append("\n");
                }
            }
        }
        
        System.out.println(sb);
    }
}
