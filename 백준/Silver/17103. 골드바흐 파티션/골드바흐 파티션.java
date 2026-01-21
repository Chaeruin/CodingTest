import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MAX = 1000000;
    static boolean[] isPrime = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sieve(); // 소수 배열 미리 생성

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(countGoldbach(n)).append("\n");
        }

        System.out.print(sb);
    }

    static void sieve() {
        for (int i = 2; i <= MAX; i++) isPrime[i] = true;

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    static int countGoldbach(int n) {
        int count = 0;

        for (int i = 2; i <= n / 2; i++) {
            if (isPrime[i] && isPrime[n - i]) count++;
        }

        return count;
    }
}
