import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            set.add(input);
        }

        List<String> list = new ArrayList<>(set);

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }
                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();

        for (String str : list) {
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}
