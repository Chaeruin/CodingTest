import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    int dist;
    int index;

    public Point(int dist, int index){
        this.dist = dist;
        this.index = index;
    }

    @Override
    public int compareTo(Point point) {
        // dist가 작으면 정렬 했을 때 앞
        if(this.dist != point.dist)
            return this.dist - point.dist;
        // index가 작으면 정렬 했을 때 앞
        return this.index - point.index;
    }
}

public class Main {
    
    public static int getDistFromOrigin(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Point[] point = new Point[n];
        
        int x, y;
        for(int i = 0; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();

            point[i] = new Point(getDistFromOrigin(x, y), i + 1);
        }

        Arrays.sort(point);

        for(int i = 0; i < n; i++)
            System.out.println(point[i].index);

    }
}
