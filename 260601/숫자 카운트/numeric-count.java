import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Hint[] hints = new Hint[N];
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            hints[i] = new Hint(number, strike, ball);
        }

        int possibleCount = 0;

        for (int i = 123; i <= 987; i++) {
            if (!hasDuplicateOrZero(i)) continue; 

            boolean isAnswerCandidate = true;

            for (Hint hint : hints) {
                int strike = countStrike(i, hint.number);
                int ball = countBall(i, hint.number);

                if (strike != hint.strike || ball != hint.ball) {
                    isAnswerCandidate = false;
                    break;
                }
            }

            if (isAnswerCandidate) possibleCount++;
        }

        System.out.println(possibleCount);
    }

    static int countStrike(int n, int number) {
        int oneN = n % 10;
        int twoN = ((n - oneN) % 100) / 10;
        int threeN = n / 100;
        
        int one = number % 10;
        int two = ((number - one) % 100) / 10;
        int three = number / 100;

        int count = 0;

        if (oneN == one) count++;
        if (twoN == two) count++;
        if (threeN == three) count++;

        return count;
    }

    static int countBall(int n, int number) {
        int oneN = n % 10;
        int twoN = ((n - oneN) % 100) / 10;
        int threeN = n / 100;
        
        int one = number % 10;
        int two = ((number - one) % 100) / 10;
        int three = number / 100;

        int count = 0;

        if (oneN == two || oneN == three) count++;
        if (twoN == one || twoN == three) count++;
        if (threeN == one || threeN == two) count++;

        return count;
    }

    static boolean hasDuplicateOrZero(int num) {
        int one = num % 10;
        int two = ((num - one) % 100) / 10;
        int three = num / 100;

        if (one == two || two == three || one == three) return false;
        if (one == 0 || two == 0 || three == 0) return false;
        return true;
    }
}

class Hint {
    int number;
    int strike;
    int ball;

    public Hint(int number, int strike, int ball) {
        this.number = number;
        this.strike = strike;
        this.ball = ball;
    }
}


