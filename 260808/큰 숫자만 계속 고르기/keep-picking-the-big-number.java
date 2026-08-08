import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            int poll = queue.poll();
            poll--;
            queue.add(poll);
        }

        System.out.println(queue.peek());
    }
}