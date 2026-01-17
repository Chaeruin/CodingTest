
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int N = 0;

        for (int i = 1; i < input; i++) {
            if (digitSum(i) == input) {
                N = i;
                break;
            }
        }

        System.out.println(N);
    }

    static int digitSum(int n) {
        int sum = n;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
}
