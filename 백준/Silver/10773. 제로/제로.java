import java.util.*;
import java.io.*;

class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        
        N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            
            if (input == 0) {
                stack.pop();
            } else {
                stack.push(input);
            }
        }
        
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        
        System.out.println(sum);
    }
}
    