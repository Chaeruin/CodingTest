
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Set<String> inputs = new HashSet<>();

        for (int i = 0; i < N; i++) {
            inputs.add(br.readLine());
        }

        List<String> list = new ArrayList<>(inputs);

        list.sort((n1, n2) -> {
            if(n1.length() != n2.length()) {
                return n1.length() - n2.length();
            }
            return n1.compareTo(n2);
        });
        
        for(String l: list) {
            sb.append(l).append('\n');
        }
        System.out.println(sb);
    }
}
