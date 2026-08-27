import java.util.Scanner;

public class Main {

    public static long N, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
        K = sc.nextLong();
        
        long low = 1;
        long high = N * N;
        long ans = N * N;

        while (low <= high) {
            long mid = (low + high) / 2;

            long val = 0;
            for (int i = 1; i <= N; i++) 
                val += Math.min(N, mid / i);

            if (val >= K) {
                high = mid - 1;
                ans = Math.min(ans, mid);
            }
            else low = mid + 1;
        }

        System.out.print(ans);
    }
}