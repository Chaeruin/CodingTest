import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Map<String, String> enterLog = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String entLeave = st.nextToken();
            if (enterLog.containsKey(name) && entLeave.equals("leave")) {
                enterLog.remove(name);
            } else {
                enterLog.put(name, entLeave);
            }
        }

        List<String> nameLog = new ArrayList<>(enterLog.keySet());
        nameLog.sort(Collections.reverseOrder());

        nameLog.forEach(System.out::println);
    }
}
