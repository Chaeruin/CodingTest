import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        int ans = Integer.MAX_VALUE;

        for (int num : set) {
            Integer minus = set.floor(num - M);
            if (minus != null) ans = Math.min(ans, num - minus);
        }
        
        if (ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
}
 