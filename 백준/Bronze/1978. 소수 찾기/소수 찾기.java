
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;

        for (int i = 0; i < num; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (is_Prime(number)) count++;
        }

        System.out.println(count);

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
