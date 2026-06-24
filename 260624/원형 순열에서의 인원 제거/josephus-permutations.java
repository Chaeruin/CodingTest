import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int count = 1;

        while (!queue.isEmpty()) {
        
            if (count != K) {
                int pop = queue.poll();
                queue.add(pop);
                count++;
            }
            else if (count == K) {
                int pop = queue.poll();
                // System.out.println(pop);
                result.add(pop);
                count = 1;
            }
        }

        for (int r : result) {
            System.out.print(r + " ");
        }
    
    }
}
