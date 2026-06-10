import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] arr = new int[7];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 7; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int a = arr[0];
        int b = arr[1];

        int total = arr[6];

        int c = total - a - b;

        System.out.print(a + " ");
        System.out.print(b + " ");
        System.out.print(c);
    }
}
