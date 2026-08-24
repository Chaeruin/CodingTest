import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr, input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        input = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            System.out.println(lowerBound(input[i]));
        }

    }

    static int lowerBound(int target) {
        int left = 1;                        
        int right = N;                    
        int minIdx = -1;                       
        while (left <= right) {                
            int mid = (left + right) / 2;      
            if(arr[mid] == target) {                      
                minIdx = mid;
            }
            if (arr[mid] < target)                             
                left = mid + 1;   
            else 
                right = mid - 1;             
        }

        return minIdx;                       
    }
}