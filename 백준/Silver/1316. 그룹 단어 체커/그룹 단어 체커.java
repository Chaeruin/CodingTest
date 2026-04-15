import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int notGroupCount = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            boolean[] arr = new boolean[26];

            for (int j = 0; j < input.length(); j++) {
                if (!arr[input.charAt(j) - 'a']) {
                    arr[input.charAt(j) - 'a'] = true;
                } else if (j > 0 && input.charAt(j) != input.charAt(j - 1)) {
                    notGroupCount++;
                    break;
                }
            }
        }
        System.out.println(N - notGroupCount);
    }
}