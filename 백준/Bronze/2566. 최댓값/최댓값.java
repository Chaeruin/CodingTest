import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[][] arr = new int[9][9];
        int max = Integer.MIN_VALUE;
        int maxIndexI = 0;
        int maxIndexJ = 0;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (max < arr[i][j]) {
                    max = arr[i][j];
                    maxIndexI = i + 1;
                    maxIndexJ = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.println(maxIndexI + " " + maxIndexJ);

    }
}
