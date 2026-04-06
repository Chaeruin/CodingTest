import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            boolean[] arr = new boolean[26];

            for (int j = 0; j < str.length(); j++) {
                if (!arr[str.charAt(j) - 'a']) {
                    arr[str.charAt(j) - 'a'] = true;
                } else if (j > 0 && str.charAt(j) != str.charAt(j - 1)) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(N - count);

    }
}
