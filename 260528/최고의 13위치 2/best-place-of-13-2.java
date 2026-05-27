import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        coin = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                coin[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxCnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N - 2; j++) {
                for(int k = 0; k < N; k++) {
                    for(int l = 0; l < N - 2; l++) {
                        if (i == k && Math.abs(j-l) <= 2)
                            continue;
                        maxCnt = Math.max(maxCnt, coin[i][j] + coin[i][j + 1] + coin[i][j + 2] + coin[k][l] + coin[k][l + 1] + coin[k][l + 2]);
                    }      
                } 
            }       
        }
                
            
        
        System.out.println(maxCnt);
    }
}