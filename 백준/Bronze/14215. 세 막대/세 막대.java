

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int tmp = 0;

        if (a < b) {
            tmp = a;
            a = b;
            b = tmp;
        }
        if (a < c) {
            tmp = a;
            a = c;
            c = tmp;
        }

        while (true) {
            int sum = a + b + c;
            if (b + c > a) {
                System.out.println(sum);
                break;
            } else {
                a--;
            }
        }
    }
}
