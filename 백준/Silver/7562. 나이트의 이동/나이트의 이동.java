import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] dx = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        int[] length = new int[N];
        List<int[]> start = new LinkedList<>();
        List<int[]> end = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            length[i] = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            start.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            st = new StringTokenizer(br.readLine());
            end.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        for (int i = 0; i < N; i++) {
            int answer = bfs(length[i], start.get(i), end.get(i));
            System.out.println(answer);
        }
    }

    public static int bfs(int length, int[] start, int[] end) {
        boolean[][] visited = new boolean[length][length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;

        int cnt = 0; // 이동 횟수 초기화

        while (!queue.isEmpty()) {
            int size = queue.size(); // 현재 레벨의 노드 수

            // 현재 레벨의 모든 노드 탐색
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                
                // 목표 지점 도달 시 이동 횟수 반환
                if (x == end[0] && y == end[1]) {
                    return cnt;
                }
                
                // 8방향 탐색
                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    
                    if (nx >= 0 && nx < length && ny >= 0 && ny < length && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }

            cnt++; // 현재 레벨이 끝나면 이동 횟수 증가
        }
        
        return -1; // 목표 지점에 도달할 수 없는 경우
    }
}
