import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push_front")) {
                int k = Integer.parseInt(st.nextToken());
                dq.addFirst(k);
            }
            if (command.equals("push_back")) {
                int k = Integer.parseInt(st.nextToken());
                dq.addLast(k);
            }
            if (command.equals("pop_front")) {
                System.out.println(dq.pollFirst());
            }
            if (command.equals("pop_back")) {
                System.out.println(dq.pollLast());
            }
            if (command.equals("size")) {
                System.out.println(dq.size());
            }
            if (command.equals("empty")) {
                if (dq.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            if (command.equals("front")) {
                System.out.println(dq.peekFirst());
            }
            if (command.equals("back")) {
                System.out.println(dq.peekLast());
            }
        }
    }
}