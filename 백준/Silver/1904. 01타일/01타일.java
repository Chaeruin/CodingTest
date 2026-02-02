
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static int[] dp = new int[1_000_001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1 : 1
        // 2 : 2
        // 3 : 001, 100, 111 -> 3
        // 4 : 5
        // 5 : 00001, 00100, 10000, 11100, 10011, 11001, 00111, 11111 -> 8
        // 점화식 : dp[i] = dp[i - 1] + dp[i - 2]
        
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }
        
        System.out.println(dp[N]);
    }
}
