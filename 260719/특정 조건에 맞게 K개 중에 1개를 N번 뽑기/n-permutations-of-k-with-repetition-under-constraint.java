import java.io.*;
import java.util.*;

public class Main {

    public static int K, N;
    public static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        selected = new int[N];

        dfs(0);
    }

    public static void dfs(int depth){

        if(depth == N){
            printAnswer();
            return;
        }

        for(int num = 1; num <= K; num++){

            selected[depth] = num;

            if(check(depth))
                continue;

            dfs(depth + 1);
        }

    }

    public static boolean check(int depth){
        
        if(depth < 2)
            return false;
       
        if(selected[depth] == selected[depth - 1] && selected[depth - 1] == selected[depth - 2])
            return true;

        return false;
    }

    public static void printAnswer() {
        StringBuilder sb = new StringBuilder();

        for (int i : selected) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

}