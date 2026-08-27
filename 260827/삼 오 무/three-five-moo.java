import java.io.*;
import java.util.*;

public class Main {

    public static final int INT_MAX = Integer.MAX_VALUE;
    public static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Long.parseLong(br.readLine());

        long left = 1;
        long right = INT_MAX;
        long minNum = INT_MAX;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (getNumOfNumbers(mid) >= N) {
                right = mid - 1;
                minNum = Math.min(minNum, mid);
            } else left = mid + 1;
        }

        System.out.print(minNum); 
    }

    public static long getNumOfNumbers(long mid) {
        long mooCnt = mid / 3 + mid / 5 - mid / 15;

        return mid - mooCnt;
    }
}
 
