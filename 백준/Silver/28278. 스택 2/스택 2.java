
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            if (input == 1) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (input == 2) {
                if (!stack.isEmpty()) System.out.println(stack.pop());
                else System.out.println("-1");
            } else if (input == 3) {
                System.out.println(stack.size());
            } else if (input == 4) {
                if (!stack.isEmpty()) System.out.println("0");
                else System.out.println("1");
            } else if (input == 5) {
                if (!stack.isEmpty()) System.out.println(stack.peek());
                else System.out.println("-1");
            }
        }
    }
}
