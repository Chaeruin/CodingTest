import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        line = new int[N][2];
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            line[i][0] = x1;
            line[i][1] = x2;
            // y1 = 0, y2 = 1 로 전체 가정됨
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            boolean hasConflict = false; 
            
            for (int j = 0; j < N; j++) {
                if (i == j) continue; 
                
                if (isConflict(line[i], line[j])) {
                    hasConflict = true; 
                    break;              
                }
            }
            
            if (!hasConflict) {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean isConflict(int[] line1, int[] line2) {
        if ((line1[0] < line2[0] && line2[1] < line1[1]) || (line1[0] > line2[0] && line2[1] > line1[1]))
            return true;
        return false;
    }
}





// 겹치는 선분 조건
// 0. x1 = x2 조건은 없음
// 1. 기울기가 다르고
// 2. 그 때의 x1 x1' 값이 x1 < x1' 일 때
//    x2' < x2 인 경우