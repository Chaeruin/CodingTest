import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 전체 입력되는 온도 수
        int K = Integer.parseInt(st.nextToken());   // 연속적인 K 일

        long[] prefixSum = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        long max = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++) {
            max = Math.max(max, (prefixSum[i] - prefixSum[i - K]));
        }
        System.out.println(max);

    }
}
