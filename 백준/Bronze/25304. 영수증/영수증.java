
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int number = Integer.parseInt(br.readLine());
        int calcTotal = 0;
        StringTokenizer st = null;
        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            
            calcTotal += price * num;
        }
        
        if (total == calcTotal) System.out.println("Yes");
        else System.out.println("No");
    }
}
