import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberA = Integer.parseInt(br.readLine());
        int numberB = Integer.parseInt(br.readLine());

        int numberThree = numberA * (numberB % 10);
        int numberFour = numberA * ((numberB % 100) / 10);
        int numberFive = numberA * (numberB / 100);

        int numberSix = numberA * numberB;

        System.out.println(numberThree);
        System.out.println(numberFour);
        System.out.println(numberFive);
        System.out.println(numberSix);
    }
}
