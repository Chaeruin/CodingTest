import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p) {
        if (this.x + this.y == p.x + p.y)
            return this.x - p.x;
        return this.x + this.y - (p.x + p.y);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Pair> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            queue.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < M; i++) {
            Pair p = queue.poll();

            p.x += 2;
            p.y += 2;

            queue.add(p);
        }

        Pair result = queue.poll();

        System.out.println(result.x + " " + result.y);
    }
}
 