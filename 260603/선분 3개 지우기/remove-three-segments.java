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
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i = 0; i < N; i++)
            for(int j = i + 1; j < N; j++)
                for(int k = j + 1; k < N; k++) {
                    
                    boolean overlap = false;
                    int[] arr = new int[101];
                    
                    for(int x = 0; x < N; x++) {
                        if(x == i || x == j || x == k)
                            continue;
                        
                        for(int y = line[x][0]; y <= line[x][1]; y++)
                            arr[y]++;
                    }
                    
                    for(int x = 0; x <= 100; x++)
                        if(arr[x] > 1)
                            overlap = true;
                    
                    if(overlap == false)
                        ans++;
                }
        
        System.out.print(ans);
    }
}



