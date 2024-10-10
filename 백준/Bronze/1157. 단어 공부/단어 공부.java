import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toUpperCase();

        Stream<String> stream = Stream.of(input.split(""));
        Map<String, Integer> map = stream.collect(
            Collectors.toMap(Function.identity(), value -> 1, Integer::sum)
        );

        String PreStr = "";
        int max = 0;

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            int val = (int)m.getValue();
            if (val > max) {
                max = val;
                PreStr = m.getKey();
            }
            else if (val == max) {
                PreStr = "?";
            }
        }

        System.out.println(PreStr);
    }
}