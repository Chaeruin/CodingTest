import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] posA = new int[1000001];
        int[] posB = new int[1000001];

        int timeA = 1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            while(t-- > 0) {
                posA[timeA] = posA[timeA - 1] + v;
                timeA++;
            }
        }

        int timeB = 1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            while(t-- > 0) {
                posB[timeB] = posB[timeB - 1] + v;
                timeB++;
            }
        }

        int leader = 0, ans = 0;
        for(int i = 1; i < timeA; i++) {
            if(posA[i] > posB[i]) {
                if(leader == 2)
                    ans++;
                leader = 1; 
            }
            else if(posA[i] < posB[i]) {
                if(leader == 1)
                    ans++;
                leader = 2; 
            }
        }
        
        System.out.print(ans);
        
    }
}