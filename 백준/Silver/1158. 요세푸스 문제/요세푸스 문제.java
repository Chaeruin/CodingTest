import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static List<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new ArrayList<>();
        
        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }
 
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        int idx = 0;
        
        while (arr.size() > 1) {
            if (idx + K - 1 < arr.size()) {
                idx = idx + K - 1;
            } else {
                idx = (idx + K - 1) % arr.size();
            }
            sb.append(arr.get(idx) + ", ");
            arr.remove(idx);
        }
        sb.append(arr.get(0) + ">");
        
        System.out.println(sb);
        
    }
}