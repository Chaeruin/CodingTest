import java.util.*;
import java.io.*;

public class Solution {
    static int N, K;
    static double[] scores;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();

        for (int i = 1; i < TC+1; i++) {
            N = sc.nextInt();
            K = sc.nextInt();

            scores = new double[N+1];

            for (int j = 1; j <= N; j++) {
                scores[j] = sc.nextInt() * 0.35 + sc.nextInt() * 0.45 + sc.nextInt() * 0.2;
            }
            double iWantToKnow = scores[K];

            Arrays.sort(scores);

            Map<Double, String> scoreScore = new HashMap<>();
            String[] Score = new String[] {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
            for (int j = N, k = 0; j >= 1; j-= N/10, k++) {
                for (int l = j; l > j - N/10; l--) {
                    scoreScore.put(scores[l], Score[k]);
                }
            }
            System.out.printf("#%d %s\n", i, scoreScore.get(iWantToKnow));
        }
    }
}
