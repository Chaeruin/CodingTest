import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0, cnt = 0;

        for (int i = 0; i < N; i++) {
            if (i >= 1 && ((arr[i] < 0 && arr[i - 1] < 0) || (arr[i] > 0 && arr[i - 1] > 0)))
                cnt++;
            else cnt = 1;

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}