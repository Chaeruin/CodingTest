import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }

                double avg = ((double)sum / (j - i + 1));

                for (int k = i; k <= j; k++) {
                    if (avg == arr[k]) {
                        count++; 
                        break;
                    }
                }
            }
        }

        System.out.print(count);
    }
}



