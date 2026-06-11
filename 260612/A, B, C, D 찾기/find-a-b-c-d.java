import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[15];
        for (int i = 0; i < 15; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int A = arr[0];
        int B = arr[1];

        int ABCD = arr[14];

        for(int i = 2; i < 15 - 2; i++){
            for(int j = i + 1; j < 15 - 1; j++){
                if(A + B + arr[i] + arr[j] == ABCD){
                    System.out.println(A + " " + B + " " + arr[i] + " " + arr[j]);
                    return;
                }
            }
        }
    }
}
