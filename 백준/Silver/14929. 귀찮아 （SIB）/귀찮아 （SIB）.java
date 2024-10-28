import java.util.*;
import java.io.*;;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] numList = new int[n];
        String[] str = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            numList[i] = Integer.parseInt(str[i]);
        }

        long sum = 0;

        for (int i = 0; i < n - 1 ; i++) {
            for(int k = i + 1; k < n; k++) {
                sum += (long)numList[i] * numList[k];
            }
        }

        System.out.println(sum);
    }
}
