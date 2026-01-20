
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        long[] input = new long[T];

        for (int i = 0; i < T; i++) {
            input[i] = Long.parseLong(br.readLine());
        }

        for (int i = 0; i < T; i++) {
            if(input[i] == 0 | input[i] == 1 ) {
                sb.append(2).append("\n");
                continue;
            } else {
                sb.append(isPrime(input[i])).append("\n");
            }
        }

        System.out.println(sb);
    }

    static long isPrime(long prime) {
        while(true) {
            long cnt = 0;
            for(long j = 2; j <= Math.sqrt(prime); j++) {
                if(prime % j ==0) {
                    cnt++;
                    break;
                }
            }
            if(cnt == 0) {
                return prime;
            }
            prime++;
        }
    }
}
