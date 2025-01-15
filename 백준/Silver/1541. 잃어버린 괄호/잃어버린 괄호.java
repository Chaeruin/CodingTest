
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split("-");

        int sum = 0;

        for (int i = 0; i < inputs.length; i++) {
            String[] inputStr = inputs[i].split("\\+");
            int plusMinusSum = 0;
            for (String s : inputStr) {
                plusMinusSum += Integer.parseInt(s);
            }
            if (i == 0) {
                sum += plusMinusSum;
            } else {
                sum -= plusMinusSum;
            }
        }

        System.out.println(sum);
    }
}
