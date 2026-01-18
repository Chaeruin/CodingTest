
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] list = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            list[i][0] = Integer.parseInt(input[0]);
            list[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(list, (x, y) -> {
            if (x[1] == y[1]) {
                return x[0] - y[0];
            }
            return x[1] - y[1];
        });

        for (int i = 0; i < N; i++) {
            System.out.println(list[i][0] + " " + list[i][1] );
        }
    }
}
