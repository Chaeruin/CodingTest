import java.io.*;

public class Main {
    static int[] queen;
    static int N, count = 0;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        queen = new int[N];

        nQueen(0);
        System.out.println(count);
    }
    static void nQueen(int depth){
        if(depth == N){
            count++;
            return;
        }
        for(int i = 0; i < N; i++){
            queen[depth] = i;
            if(possibility(depth)){
                nQueen(depth + 1);
            }
        }
    }

    static boolean possibility(int col) {
        for (int i = 0; i < col; i++) {
            if (queen[col] == queen[i]) {
                return false;
            }
            else if (Math.abs(col - i) == Math.abs(queen[col] - queen[i])) {
                return false;
            }
        }

        return true;
    }
}
