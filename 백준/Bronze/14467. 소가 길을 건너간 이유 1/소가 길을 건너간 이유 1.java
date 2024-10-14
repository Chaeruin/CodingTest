import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static int cnt = 0;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int i = 0;

        Map<String, String> observe = new HashMap<>();

        while (i < N) {
            String[] str = br.readLine().split(" ");

            String tmp = observe.get(str[0]);
            if (tmp == null) {
                observe.put(str[0], str[1]);
            }
            else if (tmp != null && tmp.equals(str[1])) {
                i++;
                continue;
            }
            else if (tmp != null) {
                cnt++;
                observe.replace(str[0], str[1]);
            }
            i++;
        }
        
        System.out.println(cnt);
    }
}
