import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> { 
    int first, second;

    public Pair(int first, int second) { 
        this.first = first; 
        this.second = second; 
    }
        
    @Override
    public int compareTo(Pair b) {
        if(first != b.first) return first - b.first;
        return second - b.second;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // N 개의 선분
        // 선분 1에 대해 :: 원점 ~ M(1)((길이)) 만큼 왼 or 오
        // 선분 1에 대해 :: 길이 방향
        // 선분 N개가 뻗어 나가 위치할 때
        // K 개 이상 겹치는 곳 - 의 길이의 합

        ArrayList<Pair> segments = new ArrayList<>();
        ArrayList<Pair> points = new ArrayList<>();

        int curX = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int dist = Integer.parseInt(st.nextToken());
            char cDir = st.nextToken().charAt(0);
            if(cDir == 'L') {
                segments.add(new Pair(curX - dist, curX));
                curX -= dist;
            }
            else {
                segments.add(new Pair(curX, curX + dist));
                curX += dist;
            }
        }

        for (int i = 0; i < N; i++) {
            int x1 = segments.get(i).first;
            int x2 = segments.get(i).second;
            points.add(new Pair(x1, +1)); // 시작점
            points.add(new Pair(x2, -1)); // 끝점
        }

        Collections.sort(points);

        int sumVal = 0;
        int ans = 0;
        for(int i = 0; i < 2 * N; i++) {
            int x = points.get(i).first;
            int v = points.get(i).second;

            if(sumVal >= K) {
                int prevX = points.get(i - 1).first;
                ans += x - prevX;
            }

            sumVal += v;
        }
        
        System.out.print(ans);
    }
}
 