import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        char[] gamer = new char[N];
        int[] score = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gamer[i] = st.nextToken().charAt(0);
            score[i] = Integer.parseInt(st.nextToken());
        }

        int currentA = 0, currentB = 0;
        int count = 0;
        int flag = 0; // 0 - A,B / 1 - A / 2 - B

        for (int i = 0; i < N; i++) {
            if (gamer[i] == 'A') currentA += score[i];
            else currentB += score[i];

            if (isWin(currentA, currentB) == 0 && flag != 0) count++;
            if (isWin(currentA, currentB) == 1 && flag != 1) count++;
            if (isWin(currentA, currentB) == 2 && flag != 2) count++;
            flag = isWin(currentA, currentB);
        }

        System.out.println(count);
    }

    static int isWin(int a, int b) {
        if (a > b) return 1;
        if (a < b) return 2;
        else return 0;
    }
}
