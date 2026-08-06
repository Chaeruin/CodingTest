import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            TreeSet<Integer> set = new TreeSet<>();

            int K = Integer.parseInt(br.readLine());
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);

                if (command == 'I') {
                    int d = Integer.parseInt(st.nextToken());
                    set.add(d);
                } else {
                    int d = Integer.parseInt(st.nextToken());
                    int remove = -1;
                    if (set.isEmpty()) continue;
                    if (d == 1) remove = set.last();
                    else if (d == -1) remove = set.first();

                    set.remove(remove);
                }
            }

            if (set.isEmpty()) System.out.println("EMPTY");
            else System.out.println(set.last() + " " + set.first());
        }

        
    }
}
 