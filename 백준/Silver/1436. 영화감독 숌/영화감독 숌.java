import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int count = 0;

        int devil = 665;

        while (true) {
            devil++;
            if (Integer.toString(devil).contains("666")) count++;
            if (count == input) {
                System.out.println(devil);
                break;
            }
        }
    }
}
