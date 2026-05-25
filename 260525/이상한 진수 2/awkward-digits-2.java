import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] arr = br.readLine().toCharArray();

        boolean piv = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                arr[i] = '1';
                piv = true;
                break;
            }
        }

        if (!piv) arr[arr.length - 1] = '0';

        int sum = 0;
        int count = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '0') {
                count *= 2;
                continue;
            } else {
                sum += ((arr[i] - '0') * count);
                count *= 2;
            }
        }

        System.out.println(sum);
    }
}