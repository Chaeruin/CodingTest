import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ONE_DAY_HOURS = 24;
        int i = 0, tHour = 0, work = 0;

        while (i < ONE_DAY_HOURS) {
            if (tHour + A <= M){
                tHour += A;
                work += B;
            } 
            else {
                tHour -= C;
                if (tHour < 0) tHour = 0;
            }
            i++;
        }

        if (A > M) {
            work = 0;
        }

        System.out.println(work);
    }
}
