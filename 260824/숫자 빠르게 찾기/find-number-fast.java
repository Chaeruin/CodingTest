import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int[] input = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            int idx = -1;

            int left = 1, right = N;
            while (left <= right) {
                int mid = (left + right) / 2;
                if(arr[mid] == input[i]) {
                    idx = mid;
                    break;
                }
                
                if(arr[mid] > input[i]) 
                    right = mid - 1; 
                else                 
                    left = mid + 1;
            }
            
            System.out.println(idx);
        }

        
    }
}
