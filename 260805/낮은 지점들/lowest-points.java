import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Long> map = new HashMap<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());

            if (map.containsKey(x) && map.get(x) > y) {
                map.put(x, y);
            } else if (!map.containsKey(x)) map.put(x, y);
        }

        long sum = 0;

        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            sum += entry.getValue();
        }

        System.out.println(sum);
    }
}
 