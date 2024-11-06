import java.util.*;
import java.io.*;

public class Solution {

    static int N;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int k = 1; k <= 10; k++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            List<Integer> box = new ArrayList<>();
            
            for (int j = 0; j < 100; j++) {
                box.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < N; i++) {
                // 최대값과 최소값을 찾아 평탄화 작업
                int max_index = box.indexOf(Collections.max(box));
                int min_index = box.indexOf(Collections.min(box));
                
                // 높이 조정
                box.set(max_index, box.get(max_index) - 1);
                box.set(min_index, box.get(min_index) + 1);
            }

            // 평탄화 후 최대 높이 차이 계산
            int result = Collections.max(box) - Collections.min(box);
            System.out.printf("#%d %d\n", k, result);
        }
    }
}