import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        long count = 0;

        for (int i = 0; i < N; i++) {
            heap.offer(Integer.parseInt(br.readLine()));
        }

        int prefix = 0;

        while (heap.size() >= 2) {
            int c1 = heap.poll();
            int c2 = heap.poll();
            int sum = c1 + c2;
            count += sum;

            heap.offer(sum);
        }

        System.out.println(count);
    }
}
