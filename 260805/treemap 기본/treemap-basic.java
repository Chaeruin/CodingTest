import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int key = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                tree.put(key, value);
            } else if (command.equals("remove")) {
                int key = Integer.parseInt(st.nextToken());
                tree.remove(key);
            } else if (command.equals("find")) {
                int key = Integer.parseInt(st.nextToken());
                if (!tree.containsKey(key)) System.out.println("None");
                else System.out.println(tree.get(key));
            } else if (command.equals("print_list")) {
                if (tree.isEmpty()) {
                    System.out.println("None");
                    continue;
                } else {
                    for (int key : tree.keySet()) {
                        System.out.print(tree.get(key) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}