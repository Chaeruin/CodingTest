import java.util.Scanner;

public class Solution {

    static int N, M;
    static int[][] arr;
    static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        
        for (int i = 1; i < TC+1; i++) {
            N = sc.nextInt();
            M = sc.nextInt();

            arr = new int[N][N];

            for (int j = 0; j<N;j++) {
                for (int k = 0; k< N;k++) {
                    arr[j][k] = sc.nextInt();
                }
            }

            int count = countWordPlace();

            System.out.printf("#%d %d\n", i, count);
        }
    }

    static int countWordPlace() {
        int count = 0;
        // X 축 검사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - M; j++) { 
                boolean isPlace = true;
                for (int k = 0; k < M; k++) {
                    if (arr[i][j + k] == 0) isPlace = false;
                }
                if (isPlace && (j + M < N) && arr[i][j + M] == 1) isPlace = false;
                if (isPlace && (j - 1 >= 0) && arr[i][j - 1] == 1) isPlace = false;
                if (isPlace) count++;
            }
        }

        // Y축 검사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - M; j++) { 
                boolean isPlace = true;
                for (int k = 0; k < M; k++) {
                    if (arr[j + k][i] == 0) isPlace = false;
                }
                if (isPlace && (j + M < N) && arr[j + M][i] == 1) isPlace = false;
                if (isPlace && (j - 1 >= 0) && arr[j - 1][i] == 1) isPlace = false;
                if (isPlace) count++;
            }
        }

        return count;
    }
    
}
