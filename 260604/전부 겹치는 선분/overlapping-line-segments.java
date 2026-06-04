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


        int[] line = new int[101];

        for(int k = 0; k < N; k++) {
            for (int i = arr[k][0]; i <= arr[k][1]; i++) line[i]++;
        }

        boolean isDuplicate = false;

        for (int i = 0; i < 101; i++) {
            if (line[i] == N) {
                isDuplicate = true;
                break;
            }
        }

        if(isDuplicate) System.out.print("Yes");
        else System.out.print("No");
    }
}



