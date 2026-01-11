import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        boolean[] tf = new boolean[30];

        for (int i = 0; i < 28; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            tf[number - 1] = true;
        }

        for (int n = 0; n < 30; n++) {
            if (!tf[n]) System.out.println(n + 1);
        }
    }
}
