
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = Integer.MAX_VALUE;
        boolean hasPrime = false;

        for (int i = m; i <= n; i++) {
            if (is_Prime(i)) {
                sum += i;
                min = Math.min(min, i);
                hasPrime = true;
            }
        }
        if (hasPrime) {
            System.out.println(sum);
            System.out.println(min);
        } else {
            System.out.println("-1");
        }
    }

    public static boolean is_Prime(int Number) {

        if(Number == 1){
            return false;
        }

        for(int i = 2; i <= Math.sqrt(Number); i++) {
            if(Number % i == 0) return false;
        }

        return true;
    }
}
