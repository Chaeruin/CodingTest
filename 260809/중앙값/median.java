import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int M = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= M; i++) {
                int num = Integer.parseInt(st.nextToken());

                if (left.isEmpty() || num <= left.peek()) {
                    left.add(num);
                } else {
                    right.add(num);
                }

                if (left.size() > right.size() + 1) {
                    right.add(left.poll());
                } else if (right.size() > left.size()) {
                    left.add(right.poll());
                }

                if (i % 2 != 0) {
                    sb.append(left.peek()).append(" ");
                }
                
            }
            sb.append("\n");
        }

        System.out.print(sb);

        
    }
}
 