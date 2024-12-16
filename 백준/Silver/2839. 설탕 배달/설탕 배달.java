import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[N+5];
        int maxVal = 5000/3+1;

        Arrays.fill(dp,maxVal);
        dp[3] = dp[5] = 1;

        for(int i = 6; i <= N+1; i++) {
            dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
        }

        System.out.println(String.valueOf(dp[N] >= maxVal ? -1 : dp[N]));
    }
}
