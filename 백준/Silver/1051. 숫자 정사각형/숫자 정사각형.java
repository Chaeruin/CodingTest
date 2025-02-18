import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] std;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        std = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                std[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        int l = maxL();
        int dim = l * l;
        System.out.println(dim);
        
    }
    
    
    static int maxL() {
        int answer = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int l = Math.min(M, N); l >= 1; l--) {
                    if (i + l - 1 < N && j + l - 1 < M) {
                        if (std[i][j] == std[i + l - 1][j] && std[i][j + l - 1] == std[i + l - 1][j + l - 1] && std[i][j] == std[i + l - 1][
                                j + l - 1]) {
                            answer = Math.max(answer, l);
                        }
                    }
                }
            }
        }
        return answer;
    }
}