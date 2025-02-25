import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int[] arrSort = new int[N];
        Map<Integer, Integer> rankMap = new HashMap<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = arrSort[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arrSort);
        
        int rank = 0;
        for (int value: arrSort) {
            if (!rankMap.containsKey(value)) {
                rankMap.put(value, rank);
                rank++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int value: arr) {
            sb.append(rankMap.get(value) + " ");
        }
        
        System.out.println(sb);
        
    }
}