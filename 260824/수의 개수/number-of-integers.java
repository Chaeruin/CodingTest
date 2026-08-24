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

        arr = new int[N];
        input = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            System.out.println(upperBound(input[i]) - lowerBound(input[i]));
        }
    }

    static int lowerBound(int target) {
        int left = 0;                        
        int right = N - 1;                    
        int minIdx = N;                       
        while (left <= right) {                
            int mid = (left + right) / 2;      
            if(arr[mid] >= target) {           
                right = mid - 1;               
                minIdx = Math.min(minIdx, mid);
            }
            else                               
                left = mid + 1;                
        }

        return minIdx;                       
    }

    static int upperBound(int target) {
        int left = 0;                        
        int right = N - 1;                    
        int minIdx = N;                       
        while (left <= right) {                
            int mid = (left + right) / 2;      
            if(arr[mid] > target) {           
                right = mid - 1;               
                minIdx = Math.min(minIdx, mid);
            }
            else                               
                left = mid + 1;                
        }

        return minIdx;                       
    }

}