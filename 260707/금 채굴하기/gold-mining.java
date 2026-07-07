import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[][] gold;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        gold = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                gold[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxGold = 0;


        for(int row = 0; row < N; row++) {
            for(int col = 0; col < N; col++) {
                for(int k = 0; k <= 2 * (N - 1); k++) {
                    int numOfGold = getNumOfGold(row, col, k);

                    if(numOfGold * M >= getArea(k))
                        maxGold = Math.max(maxGold, numOfGold);
                }
            }
        }

        System.out.print(maxGold);
    }

    public static int getArea(int k) {
        return k * k + (k+1) * (k+1); 
    }
    
    public static int getNumOfGold(int row, int col, int k) {
        int numOfGold = 0;
    
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                if(Math.abs(row - i) + Math.abs(col - j) <= k)
                    numOfGold += gold[i][j];
    
        return numOfGold;
    }
}
 