import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            String sorted = new String(arr);
            
            map.put(sorted, map.getOrDefault(sorted, 0) + 1);
        }

        int max = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        System.out.println(max);
    }
}
 