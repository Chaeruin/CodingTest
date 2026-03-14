import static java.lang.Character.isDigit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length())
                    return s1.length() - s2.length();
                if (getSum(s1) != getSum(s2)) {
                    return getSum(s1) - getSum(s2);
                }
                return s1.compareTo(s2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : list) sb.append(s).append("\n");
        System.out.print(sb);
    }

    public static int getSum(String str) {
        int sum = 0;
        String[] strArr = str.split("");
        for (String s : strArr) {
            if (isDigit(s.charAt(0))) sum += Integer.parseInt(s);
            else continue;
        }
        return sum;
    }
}
