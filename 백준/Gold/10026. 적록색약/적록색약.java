import java.util.*;
import java.io.*;

public class Main {
    static String[][] rGB;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int result_nor, result_rg;
	static int cnt, N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        rGB = new String[N][N];
        visited = new boolean[N][N];
        cnt = 0;

        // 정상

        for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				rGB[i][j] = str[j];
			}
		}
		
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				if(!visited[x][y]) {
					dfs(x,y);
					cnt++;
				}
			}
		}

        result_nor = cnt;

        // 비정상

        for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if (rGB[i][j].equals("G")) {
                    rGB[i][j] = "R";
                } 
			}
		}

        cnt = 0;
        visited = new boolean[N][N];

        for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				if(!visited[x][y]) {
					dfs(x,y);
					cnt++;
				}
			}
		}

        result_rg = cnt;


	    bw.write(result_nor + " ");
        bw.write(result_rg + " ");
		bw.flush();
		bw.close();
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        String tmp_char = rGB[x][y]; // R
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }

            if (!visited[nx][ny] && rGB[nx][ny].equals(tmp_char)) {
                dfs(nx, ny);
            }
        }
    }
}