import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    int index;
    int value;

    public Point(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Point p) {
        if(this.value != p.value)
            return this.value - p.value;
        return index - p.index;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Point[] arr = new Point[N];
        int[] answer = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = new Point(i, Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            answer[arr[i].index] = i + 1;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }
}