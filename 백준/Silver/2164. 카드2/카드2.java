import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Queue<Integer> card = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            card.add(i);
        }

        while (true) {
            if (card.size() == 1){
                break;
            }
            // 첫번째 값 제거.
            card.poll();
            card.add(card.poll());
        }
        System.out.println(card.peek());
    }
}
