import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int one, two;
    static int[][] xy;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        one = Integer.parseInt(st.nextToken());
        two = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        xy = new int[n + 1][n + 1];
        dist = new int[n + 1];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            xy[a][b] = xy[b][a] = 1;
        }
        
        dfs(one);
        
        if(dist[two] == 0) {
            System.out.println("-1");
        } else {
            System.out.println(dist[two]);
        }
        
        
    }
    
    static void dfs(int index) {
        if(index == two) {
            return;
        }
        
        for (int i = 1; i <= n; i ++) {
            if (xy[index][i] == 1 && dist[i] == 0) {
                dist[i] = dist[index] + 1;
                dfs(i);
            }
        }
    }
}