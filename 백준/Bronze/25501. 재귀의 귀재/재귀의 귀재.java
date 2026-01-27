
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] result = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            result[1] = 1;
            int[] rs = isPalindrome(br.readLine());
            sb.append(rs[0]).append(" ").append(rs[1]).append("\n");
        }

        System.out.println(sb);
    }

    static int[] recursion(char[] string, int l, int r) {
        if (l >= r) {
            result[0] = 1;
            return result;
        }
        else if (string[l] != string[r]) {
            result[0] = 0;
            return result;
        }
        else {
            result[1]++;
            return recursion(string, l + 1, r - 1);
        }
    }

    static int[] isPalindrome(String string) {
        return recursion(string.toCharArray(), 0, string.length()- 1);
    }
}
