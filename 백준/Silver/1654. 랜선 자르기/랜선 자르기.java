import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lantern = new int[K];

        long left = 1;
        long right = 1;

        for (int i = 0; i < K; i++) {
            lantern[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, lantern[i]);
        }

        // left가 right를 넘어서기 전까지 반복
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int i = 0; i < K; i++) {
                count += lantern[i] / mid;
            }

            if (count >= N) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}