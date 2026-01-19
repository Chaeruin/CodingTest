import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> listen = new HashSet<>();
        List<String> listLook = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            listen.add(br.readLine().trim());
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String input = br.readLine().trim();
            if(listen.contains(input)) {
                count++;
                listLook.add(input);
            }
        }

        Collections.sort(listLook);

        System.out.println(count);
        listLook.forEach(System.out::println);
    }
}
