import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else if (command.equals("pop")) {
                if (stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.pop()).append("\n");
            }
            else if (command.equals("size")) sb.append(stack.size()).append("\n");
            else if (command.equals("empty")) {
                if (stack.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if (command.equals("top")) {
                if (stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.peek()).append("\n");
            }
        }

        System.out.print(sb);
    }
}
