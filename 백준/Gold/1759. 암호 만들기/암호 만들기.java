import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] code;
    static char[] arr;
    static List<Character> vlist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        code = new char[L];
        arr = new char[C];

        vlist = List.of('a', 'e', 'i', 'o', 'u');

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr); // 입력값에 대한 선정렬로 dfs 과정에서 정렬하는 과정 생략 가능

        dfs(0, 0);
    }

    public static void dfs(int depth, int start) {
        if (depth == L) {
            if (isValid(code)) {
                for (char c : code) {
                    System.out.print(c);
                }
                System.out.println();
            }
            return;
        }
        for (int i = start; i < C; i++) {
            code[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }

    // 자음/모음 갯수 판별
    public static boolean isValid(char[] code) {
        int cons = 0;
        int vow = 0;
        for (char c : code) {
            if (vlist.contains(c)) {
                vow++;
            } else {
                cons++;
            }
        }
        if (cons >= 2 && vow >= 1) return true;
        else return false;
    }
}
