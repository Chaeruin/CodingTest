
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] splits = s.split(" ");

        int total = 0;

        for (String str : splits) {
            if (str.isEmpty()) continue;
            else total++;
        }

        System.out.println(total);
    }
}
