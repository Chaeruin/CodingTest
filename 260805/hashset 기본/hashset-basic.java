import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                set.add(x);
            } else if (command.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                set.remove(x);
            } else if (command.equals("find")) {
                int x = Integer.parseInt(st.nextToken());
                if (!set.contains(x)) System.out.println("false");
                else System.out.println("true");
            } 
        }
    }
}