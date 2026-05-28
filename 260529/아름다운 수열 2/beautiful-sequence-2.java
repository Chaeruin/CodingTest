import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arrA = new int[N];
        int[] arrB = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrB);
        int count = 0;

        for (int i = 0; i <= N - M; i++) {
            int[] temp = new int[M];
    
            for (int j = 0; j < M; j++) {
                temp[j] = arrA[i + j];
            }
            
            Arrays.sort(temp);
            
            if (Arrays.equals(temp, arrB)) {
                count++; 
            }
        }

        System.out.print(count);
    }
}



