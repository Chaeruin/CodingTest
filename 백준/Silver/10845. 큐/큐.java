
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int rear = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) queue.add(rear = Integer.parseInt(st.nextToken()));
            else if (command.equals("pop")) {
                if (queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.poll()).append("\n");
            }
            else if (command.equals("size")) sb.append(queue.size()).append("\n");
            else if (command.equals("empty")) {
                if (queue.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if (command.equals("front")) {
                if (queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.peek()).append("\n");
            }
            else if (command.equals("back")) {
                if (queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(rear).append("\n");
            }
        }

        System.out.print(sb);
    }
}
