import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> tree = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            tree.put(str, tree.getOrDefault(str, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : tree.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
 