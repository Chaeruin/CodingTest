import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int k = 0; k < N; k++) {
            st = new StringTokenizer(br.readLine());
            arr[k][0] = Integer.parseInt(st.nextToken());
            arr[k][1] = Integer.parseInt(st.nextToken());
        }

        boolean isDuplicate = false;

        for(int k = 0; k < N; k++) {

            int[] line = new int[101];

            for (int j = 0; j < N; j++) {
                if (k == j) continue;
                for (int i = arr[j][0]; i <= arr[j][1]; i++) line[i]++;
            }

            for (int l = 0; l < 101; l++) {
                if (line[l] == N - 1) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) break;
        }
        

        if(isDuplicate) System.out.print("Yes");
        else System.out.print("No");
    }
}



