
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;

        List<Integer> list = new ArrayList<>();

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            list.add(Integer.parseInt(input));
        }
        
        Collections.sort(list);

        int size = list.size();
        int sum = list.stream().mapToInt(Integer::intValue).sum();

        System.out.println(sum / size);
        if (size % 2 != 0) System.out.println(list.get(size / 2));
        else System.out.println((list.get(size / 2 - 1) + list.get(size / 2) / 2));
    }
}
