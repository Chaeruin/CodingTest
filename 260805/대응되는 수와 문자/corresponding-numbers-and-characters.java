import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        String[] arr = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String key = br.readLine();
            map.put(key, i);
            arr[i] = key;
        }

        for (int i = 0; i < M; i++) {
            String cmd = br.readLine();

            if (map.containsKey(cmd)) {
                System.out.println(map.get(cmd));
                continue;
            } else {
                System.out.println(arr[Integer.parseInt(cmd)]);
            }
        }
    }
}
 