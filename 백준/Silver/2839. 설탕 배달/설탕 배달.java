import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int count = 0;

        while (input > 0) {
            if (input % 5 == 0) {
                count += input / 5;
                System.out.println(count);
                return;
            }
            if (input < 3) {
                System.out.println("-1");
                return;
            }
            
            input -= 3;
            count++;
        }

        System.out.println(count);
    }
}