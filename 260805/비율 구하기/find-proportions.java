import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<String, Integer> tree = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            tree.put(str, tree.getOrDefault(str, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : tree.entrySet()) {
            System.out.print(entry.getKey() + " ");
            System.out.printf("%.4f\n", (((double) entry.getValue() / n) * 100));
        }
    }
}