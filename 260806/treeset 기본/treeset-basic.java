import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        
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
            } else if (command.equals("lower_bound")) {
                int x = Integer.parseInt(st.nextToken());
                if (set.ceiling(x) == null) System.out.println("None");
                else System.out.println(set.ceiling(x));
            } else if (command.equals("upper_bound")) {
                int x = Integer.parseInt(st.nextToken());
                if (set.higher(x) == null) System.out.println("None");
                else System.out.println(set.higher(x));
            } else if (command.equals("largest")) {
                if (set.isEmpty()) System.out.println("None");
                else System.out.println(set.last());
            } else if (command.equals("smallest")) {
                if (set.isEmpty()) System.out.println("None");
                else System.out.println(set.first());
            }
        }
    }
}