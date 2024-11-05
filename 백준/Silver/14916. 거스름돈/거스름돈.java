import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int fiveNumber = N / 5;

        while (fiveNumber >= 0) {
            int remaining = N - (5 * fiveNumber);

            // 2원으로 나누어 떨어지면 종료
            if (remaining % 2 == 0) {
                int twoNumber = remaining / 2;
                System.out.println(fiveNumber + twoNumber);
                return;
            }

            // 5원 동전 개수 줄이기
            fiveNumber--;
        }

        // 5원과 2원으로 거슬러 줄 수 없는 경우
        System.out.println(-1);
    }
}
