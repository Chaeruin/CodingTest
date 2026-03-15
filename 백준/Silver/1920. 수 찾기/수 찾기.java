import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();

        for (int l : list) {
            if (set.contains(l)) sb.append("1").append("\n");
            else sb.append("0").append("\n");
        }

        System.out.print(sb);
    }
}
