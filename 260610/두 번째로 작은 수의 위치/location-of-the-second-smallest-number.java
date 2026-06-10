import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());  

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }  

        Set<Integer> set = new HashSet<Integer>(Arrays.asList(arr));
        Integer[] copy = set.toArray(new Integer[0]);

        Arrays.sort(copy);

        int pivot = -1;
        if (copy.length > 1) pivot = copy[1];
        else {
            System.out.println(-1);
            return;
        }

        int count = 0; 
        int result = -1;


        for (int i = 0; i < N; i++) {
            if (arr[i] == pivot) {
                count++;
            }

            if (count <= 1 && arr[i] == pivot) result = i + 1;
            else if (count >= 2) result = -1;
        }  

        System.out.println(result);
    }
}
