
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numerator1 = Integer.parseInt(st.nextToken());
        int denominator1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int numerator2 = Integer.parseInt(st.nextToken());
        int denominator2 = Integer.parseInt(st.nextToken());

        // new 분모 (통분 분모)
        int lcmNum = lcm(denominator1, denominator2);

        int div1 = divLcm(denominator1, lcmNum);
        int div2 = divLcm(denominator2, lcmNum);

        // 통분해서 더한 분자
        int newNumerator = numerator1 * div1 + numerator2 * div2;

        // 통분해서도 기약분수로 바꿔야함
        if (gcd(lcmNum, newNumerator) == 1) {
            System.out.println(newNumerator + " " + lcmNum);
        } else {
            int divGCDNum = gcd(lcmNum, newNumerator);
            System.out.println(newNumerator/divGCDNum + " " + lcmNum/divGCDNum);
        }
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    static int lcm(int a, int b) {
        int gcdNum = gcd(a, b);
        return a * b / gcdNum;
    }

    static int divLcm(int a, int lcmNum) {
        return lcmNum / a;
    }


}
