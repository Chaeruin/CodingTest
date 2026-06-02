import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;
    static int[] work = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int k = 0; k < N; k++) {
            for (int t = arr[k][0]; t < arr[k][1]; t++) {
                work[t]++;
            }
        }

        int maxWork = 0;

        for (int i = 0; i < N; i++) {

            for (int t = arr[i][0]; t < arr[i][1]; t++) {
                work[t]--;
            }

            int working = 0;
            for (int t = 0; t < work.length; t++) {
                if (work[t] > 0) { 
                    working++;
                }
            }

            maxWork = Math.max(maxWork, working);

            for (int t = arr[i][0]; t < arr[i][1]; t++) {
                work[t]++;
            }
        }

        System.out.println(maxWork);
    }
}



