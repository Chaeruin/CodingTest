import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map1.put(name, i+1);
            map2.put(i+1, name);
        }

        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            if (Character.isDigit(command.charAt(0))) {
                bw.write(map2.get(Integer.parseInt(command))+ "\n");
            } else {
                bw.write(map1.get(command) + "\n");
            }
        }
        bw.flush();
    }
}
