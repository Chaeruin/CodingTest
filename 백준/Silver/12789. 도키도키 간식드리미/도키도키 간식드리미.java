import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int piv = 1;
        for (int i = 0; i < N; i++) {
            if (piv == arr[i]) {
                piv++;
            } else {
                stack.push(arr[i]);
            }

            while (!stack.isEmpty() && stack.peek() == piv) {
                stack.pop();
                piv++;
            }
        }


        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}