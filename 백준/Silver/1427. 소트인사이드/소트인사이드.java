import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int n = Integer.parseInt(N);

        List<Integer> list = new ArrayList<>();

        for (int i = N.length() - 1; i >= 0; i--) {
            int a = (int) (n / Math.pow(10, i));
            list.add(a);
            n -= (int) (a * Math.pow(10, i));
        }

        list.sort(Collections.reverseOrder());

        String result = list.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(""));

        System.out.println(result);
    }
}