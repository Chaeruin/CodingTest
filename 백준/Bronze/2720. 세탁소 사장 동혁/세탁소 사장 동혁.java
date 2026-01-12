
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());

        for (int i = 0; i < num; i++) {
            int charge = Integer.parseInt(br.readLine());
            if (charge >= 25) {
                int result = (int) (charge / 25);
                System.out.print(result + " ");
                charge -= 25 * result;
            } else {
                System.out.print("0 ");
            }

            if (charge >= 10) {
                int result = (int) (charge / 10);
                System.out.print(result + " ");
                charge -= 10 * result;
            } else {
                System.out.print("0 ");
            }

            if (charge >= 5) {
                int result = (int) (charge / 5);
                System.out.print(result + " ");
                charge -= 5 * result;
            } else {
                System.out.print("0 ");
            }

            if (charge >= 1) {
                int result = (int) (charge / 1);
                System.out.print(result + " ");
                charge -= 1 * result;
            }
            else {
                System.out.print("0 ");
            }
            System.out.println();
        }
    }
}
