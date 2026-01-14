
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        while (!input.equals("-1")) {
            int a = Integer.parseInt(input);
            System.out.print(a);

            int div = 1;
            int sum = 0;
            List<Integer> divlist = new ArrayList<>();

            while (div != a) {
                if (a % div == 0) {
                    sum += div;
                    divlist.add(div);
                }
                div++;
            }

            if (a != sum) System.out.println(" is NOT perfect.");
            else {
                System.out.print(" = ");
                for (int i = 0; i < divlist.size(); i++) {
                    System.out.print(divlist.get(i));
                    if (i != divlist.size() - 1) {
                        System.out.print(" + ");
                    }
                }
                System.out.println();
            }
            input = br.readLine();
        }
    }
}
