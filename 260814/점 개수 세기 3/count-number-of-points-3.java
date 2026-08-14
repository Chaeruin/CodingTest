import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        TreeSet<Integer> point = new TreeSet<>();
        int[][] pair = new int[Q][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            point.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            pair[i][0] = Integer.parseInt(st.nextToken());
            pair[i][1] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> mapper = new HashMap<>();

        int cnt = 1;
        for (Integer num : point) {
            mapper.put(num, cnt);
            cnt++;
        }

        for (int i = 0; i < Q; i++) {
            int a = pair[i][0];
            int b = pair[i][1];

            int newA = mapper.get(a);
            int newB = mapper.get(b);

            System.out.println(newB - newA + 1);
        }
    }
}
 