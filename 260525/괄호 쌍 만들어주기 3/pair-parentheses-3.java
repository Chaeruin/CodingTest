import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] arr = br.readLine().toCharArray();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] == ')') sum++;
                }
            }
        }

        System.out.println(sum);
    }
}