
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            for (String in : input) {
                if (in.equals("(")) stack.push(in);
                else {
                    if (stack.isEmpty()) {
                        stack.push(in);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }


    }
}
