import java.io.*;
import java.util.*;

class Main {
    static int K, N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        arr = new int[K];
        int max = 0;
        int min = 0;
        int mid = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
 
       long right = arr[K-1];
       long left = 1;
       long count, half;
 
       while(left <= right) {
          count = 0;
          half = (left + right)/2;
 
          for(int i = 0; i < K; i++) 
              count += arr[i] / half;
 
          if(count < N) 
              right = half - 1;
          else 
              left = half + 1;
       }
 
       System.out.println(right);
        
    }
}