import java.io.*;
import java.util.*;

public class Main {

    public static int N, answer;
    public static int[][] line;
    public static List<Integer> selected = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        line = new int[N][2];
        
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }
        
        answer = 0;
        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int idx) {

        if (idx == N){
            answer = Math.max(answer, selected.size());
            return;
        }

        // 선택 안 함
        dfs(idx + 1);

        // 선택
        if (!isDuplicated(line[idx])){
            selected.add(idx);

            dfs(idx+1);

            selected.remove(selected.size()-1);
        }
    }

    public static boolean isDuplicated(int[] check) {
        for (int idx : selected) {
            if (check[0] <= line[idx][1] && line[idx][0] <= check[1]) 
                return true;
        }
        return false;
    }
}
 