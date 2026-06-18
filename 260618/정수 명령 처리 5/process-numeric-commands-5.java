import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        List<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            
            int number = 0;
            if (cmd.equals("push_back") || cmd.equals("get"))
                number = Integer.parseInt(st.nextToken());

            if (cmd.equals("push_back")) list.add(number);
            if (cmd.equals("get")) System.out.println(list.get(number - 1));
            if (cmd.equals("size")) System.out.println(list.size());
            if (cmd.equals("pop_back")) list.remove(list.size() - 1);
        }
    }
}
