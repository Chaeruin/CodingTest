import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int key = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                map.put(key, value);
            } else if (command.equals("remove")) {
                int key = Integer.parseInt(st.nextToken());
                map.remove(key);
            } else if (command.equals("find")) {
                int key = Integer.parseInt(st.nextToken());
                if (!map.containsKey(key)) System.out.println("None");
                else System.out.println(map.get(key));
            }
        }
    }
}