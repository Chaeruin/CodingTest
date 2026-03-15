import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            if (key.length() >= M)
                map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<String> sortKeys = new ArrayList<>(map.keySet());

        sortKeys.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s1) != map.get(s2))
                    return map.get(s2) - map.get(s1);
                if (s1.length() != s2.length()) {
                    return s2.length() - s1.length();
                }
                return s1.compareTo(s2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String key : sortKeys) {
            sb.append(key).append("\n");
        }
        System.out.print(sb);
    }
}
