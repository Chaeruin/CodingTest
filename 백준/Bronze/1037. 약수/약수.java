
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> divisor = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            divisor.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(divisor);

        System.out.println(divisor.get(0) * divisor.get(divisor.size() - 1));
    }
}
