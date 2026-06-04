import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] pigeon = new int[101];
        int[] moveDir = new int[101];
        int[] pos = new int[11];
        
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pigeon[i] = Integer.parseInt(st.nextToken());
            moveDir[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= 10; i++)
            pos[i] = -1;
        
        int moveCnt = 0;

        for(int i = 0; i < N; i++) {
            if(pos[pigeon[i]] == -1) {
                pos[pigeon[i]] = moveDir[i];
            }
            else if(pos[pigeon[i]] != moveDir[i]) {
                pos[pigeon[i]] = moveDir[i];
                moveCnt++;
            }
        }

        System.out.print(moveCnt);
    }
}



