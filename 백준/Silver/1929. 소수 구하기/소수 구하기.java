import java.io.*;
import java.util.*;

class Main {
    static int M, N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        for (int i = M; i <= N; i++) {
            if (isDecimal(i)) {
                System.out.println(i);
            }
        }
    }
    
    static boolean isDecimal(int d) {
        if (d == 1) return false;
        for (int i = 2; i * i <= d; i++) {
            if (d % i == 0) {
                return false;
            }
        }
        return true;
    }
}