import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String command = st.nextToken();
            if (command.equals("enter")) {
                set.add(name);
            } else if (command.equals("leave")) {
                set.remove(name);
            }
        }
        
        List<String> list = new ArrayList<>(set);

        list.sort(Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (String name : list) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}
