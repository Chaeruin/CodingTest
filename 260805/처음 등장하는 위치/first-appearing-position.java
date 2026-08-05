import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            if (tree.containsKey(key)) continue;
            tree.put(key, i + 1);
        }

        for (Map.Entry<Integer, Integer> entry : tree.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
 