import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static String command;
    static int commandInt;
    public static void main(String[] args) throws NumberFormatException, IOException {
        Stack<Integer> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int i = 0;

        String[] st;

        while (i < N) {
            st = br.readLine().trim().split(" ");
            command = st[0];


            if (st.length == 2) {
                commandInt = Integer.parseInt(st[1]);
            }

            if (command.equals("push")) {
                stack.push(commandInt);
            } else if (command.equals("pop")) {
                if (stack.size() == 0) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(stack.peek());
                    stack.pop();
                }
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                if (stack.size() == 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (command.equals("top")) {
                if (stack.size() == 0) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(stack.peek());
                }
            }
            i++;
        }
    }
}
