import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int i = N;

        while (i >= N) {
            String numToString = Integer.toString(i);
            boolean isPel = returnPelin(numToString);
            boolean isPrime = returnPrime(i);

            if (isPel && isPrime) {
                break;
            } 

            i++;
        }
        System.out.println(i);
    }

    public static boolean returnPelin(String numToString) {
        int strLength = numToString.length();
        for (int k = 0; k < strLength / 2; k++) {
            if (numToString.charAt(k) != numToString.charAt(strLength - 1 - k)) {
                return false;
            }
        }
        return true;
    }

    public static boolean returnPrime(int i) {
        if (i < 2) return false;
        for (int k = 2; k * k <= i; k++) {
            if (i % k == 0) return false;
        }
        return true;
    }
}
