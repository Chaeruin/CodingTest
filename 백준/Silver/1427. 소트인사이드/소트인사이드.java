import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");

        Integer[] number = Arrays.stream(input)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

        Arrays.sort(number, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (int n : number) {
            sb.append(n);
        }

        System.out.println(sb);
    }
}
