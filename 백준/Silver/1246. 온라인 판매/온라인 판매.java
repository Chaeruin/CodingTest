import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] arr;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[M];
        result = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);

        int count = 1;
        for (int i = M - 1; i >= 0; i--) {
            result.add(count * arr[i]);
            if (count == N) {
                break;
            }
            count++;
        }
        
        Collections.sort(result, Comparator.reverseOrder());
        
        count = 1;
        for (int i = M - 1; i >= 0; i--) {
            if (count * arr[i] == result.get(0)) {
                System.out.print(arr[i] + " ");
                break;
            }
            if (count == N) {
                break;
            }
            count++;
        }
        
        System.out.println(result.get(0));
        
        
    }
}