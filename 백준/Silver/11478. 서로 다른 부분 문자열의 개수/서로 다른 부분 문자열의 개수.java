import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Set<String> set = new HashSet<>();

        for (int i = 0; i <= input.length(); i++) {
            for (int j = i; j <= input.length(); j++) {
                String str = input.substring(i, j);
                if (!str.isEmpty()) set.add(str);
            }
        }

        System.out.println(set.size());
    }
}
