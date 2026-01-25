
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N];
        double sum = 0;

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
            sum += list[i];
        }

        Arrays.sort(list);

        int count = 0;
        int max = Integer.MIN_VALUE;

        int mod = list[0];
        boolean check = false;

        for(int i = 0; i < N - 1; i++) {
            if (list[i] == list[i + 1]) {
                count++;
            } else {
                count = 0;
            }

            if (max < count) {
                max = count;
                mod = list[i];
                check = true;
            } else if(max == count && check) {
                mod = list[i];
                check = false;
            }
        }

        System.out.println(Math.round(sum / N));
        System.out.println(list[(N - 1) / 2]);
        System.out.println(mod);
        System.out.println(list[N - 1] - list[0]);

    }
}
