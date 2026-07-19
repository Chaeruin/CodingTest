import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, K, answer;
    public static int[] horse, dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        horse = new int[K];
        dice = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int turn) {

        if(turn == N){
            int count = 0;

            for(int i = 0; i < K; i++)
                if(horse[i] >= M - 1) count++;

            answer = Math.max(answer, count);

            return;
        }


        for(int i = 0; i < K; i++){

            horse[i] += dice[turn];

            dfs(turn + 1);

            horse[i] -= dice[turn];
        }
    }
}
 