
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        System.out.println(a * b / findGCD(a, b));
    }

    static long findGCD(long a, long b) {
        while ( b != 0 ) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
