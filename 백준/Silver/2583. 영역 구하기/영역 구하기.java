import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] linked;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static List<Integer> result;
	static int cnt, N, M, K;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        result = new LinkedList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        linked = new boolean[M][N];
        visited = new boolean[M][N];
        cnt = 0;

        for (boolean a[]: linked) Arrays.fill(a, false);


        for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for (int k = a; k < c; k++) {
                for (int t = b; t < d; t++) {
                    linked[k][t] = true;
                }
            }
		}
		
		
		for(int x = 0; x < M; x++) {
			for(int y = 0; y < N; y++) {
				if(!linked[x][y] && !visited[x][y]) {
                    cnt = 1;
					dfs(x,y);
					result.add(cnt);
				}
			}
		}

        Collections.sort(result);
		
		bw.write(result.size()+"\n");
		for(int r : result) bw.write(r+" ");
		bw.flush();
		bw.close();
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N && !linked[nx][ny] && !visited[nx][ny]) {
                dfs(nx, ny);
                cnt++;
            }
        }
        
    }
}
