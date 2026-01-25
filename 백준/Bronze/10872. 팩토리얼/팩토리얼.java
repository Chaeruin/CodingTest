
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        
        System.out.println(factorial(input));
    }
    
    static int factorial(int input) {
        if (input == 0) return 1;
        int result = 1;
        for (int i = 1; i <= input; i++) {
            result *= i;
        }
        return result;
    }
}
