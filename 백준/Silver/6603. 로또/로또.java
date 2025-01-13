
import java.io.*;
import java.util.*;

public class Main {

    static int K;
    static int[] lotto;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        K = Integer.parseInt(input[0]);

        while (K != 0) {
            lotto = new int[K];
            visited = new boolean[K];

            for (int i = 0; i < K; i++) {
                lotto[i] = Integer.parseInt(input[i + 1]);
            }

            comb1(0 , K, 6);
            System.out.println();

            input = br.readLine().split(" ");
            K = Integer.parseInt(input[0]);
        }
    }

    static void comb1(int start, int n, int r) {
        if(r == 0) {
            print();
            return;
        } else {
            for(int i = start; i < n; i++) {
                visited[i] = true;
                comb1(i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }

    static void print() {
        for(int i = 0; i < lotto.length; i++) {
            if(visited[i])
                System.out.print(lotto[i] + " ");
        }
        System.out.println();
    }

}
