
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int lone = Math.abs(x - w);
        int ltwo = x;
        
        int kone = Math.abs(y - h);
        int ktwo = y;

        System.out.println(Math.min(Math.min(lone, ltwo), Math.min(kone, ktwo)));
    }
}