import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> listen = new HashSet<>();
        List<String> seeNotListen = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            listen.add(br.readLine());
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            String inputSee = br.readLine();
            if (listen.contains(inputSee)) {
                count++;
                seeNotListen.add(inputSee);
            }
        }

        seeNotListen.sort(Comparator.naturalOrder());
        System.out.println(count);
        for (String str : seeNotListen) {
            System.out.println(str);
        }
    }
}
