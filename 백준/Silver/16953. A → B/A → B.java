import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(bfs(a, b));
    }

    public static int bfs(long a, int b) {
        Queue<Long> queue = new LinkedList<>();
        queue.add(a);

        cnt = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                long temp = queue.poll();
                if (temp == b) {
                    return cnt++;
                }
                long newOne = temp * 2;
                long newTwo = temp * 10 + 1;

                if (newOne <= b) {
                    queue.add(newOne);
                }
                if (newTwo <= b) {
                    queue.add(newTwo);
                }
            }
            cnt++;
        }
        return -1;
    }
}
