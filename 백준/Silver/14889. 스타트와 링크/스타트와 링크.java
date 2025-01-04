
import java.util.*;
import java.io.*;

public class Main {

    static int[][] sArr;

    static boolean[] check;
    static int N;
    static int MIN_RESULT = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        sArr = new int[N][N];
        check = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);
        System.out.println(MIN_RESULT);
    }

    static void combination(int dep, int start) {
        if(dep == N/2) {
            MIN_RESULT = Math.min(MIN_RESULT, getResult());
            return;
        }

        for(int i = start; i < N; i++) {
            check[i] = true;
            combination(dep + 1, i + 1);
            check[i] = false;
        }
    }

    static int getResult() {
        int start = 0;
        int link = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == j) continue;

                if(check[i] && check[j]) start += sArr[i][j];
                if(!check[i] && !check[j]) link += sArr[i][j];
            }
        }
        return Math.abs(start - link);
    }
}
