import java.io.*;
import java.util.*;

public class Main {

    public static String input;
    public static boolean[] exist = new boolean[6];
    public static int[] value = new int[6];
    public static int answer = Integer.MIN_VALUE;
    public static List<Integer> alpha = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            if ('a' <= c && c <= 'f') {
                exist[c - 'a'] = true;
            }
        }

        for (int i = 0; i < 6; i++) {
            if (exist[i]) alpha.add(i);
        }

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int idx) {

        if (idx == alpha.size()) {
            calculate();  
            return;
        }

        int alphabet = alpha.get(idx);

        for (int num = 1; num <= 4; num++) {
            value[alphabet] = num;

            dfs(idx + 1);
        }
    }

    public static void calculate() {

        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'a' && ch <= 'f') nums.add(value[ch - 'a']);
            else ops.add(ch);
        }
 
        int result = nums.get(0);

        for (int i = 0; i < ops.size(); i++) {

            if (ops.get(i) == '+')
                result += nums.get(i + 1);

            else if (ops.get(i) == '-')
                result -= nums.get(i + 1);

            else
                result *= nums.get(i + 1);
        }

        answer = Math.max(answer, result);
    }
}
 