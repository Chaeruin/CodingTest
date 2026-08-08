import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        while (queue.size() >= 2) {
            int one = queue.poll();
            int two = queue.poll();
            if (one == two) continue;
            else queue.add(one - two);
        }

        if (queue.isEmpty()) System.out.println(-1);
        else System.out.println(queue.poll());
    }
}
 