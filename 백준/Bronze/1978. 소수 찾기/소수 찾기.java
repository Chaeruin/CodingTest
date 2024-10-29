import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // String [] str = br.readLine().split(" ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;

        for (int k = 0; k < N; k++) {
            int i = Integer.parseInt(st.nextToken());
            if (isPrime(i)) cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean isPrime(int i) {
        if (i < 2) return false;
        int k = 2;
        while (k != i) {
            if (i % k == 0) return false;
            k++;
        }
        return true;
    }
}