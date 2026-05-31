import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] pos = new int[101];
    public static char[] alphabets = new char[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);
            pos[i] = num;
            alphabets[num] = ch;
        }

        Arrays.sort(pos, 0, N);
        int ans = 0;
        int g,h;
        for (int i = 0; i < N; i++){
            g = 0;
            h = 0;
            if (alphabets[pos[i]] == 'G') g++;
            else h++;

            for (int j = i + 1; j < N; j++){
                if (alphabets[pos[j]] == 'G') g++;
                else h++;
                
                if (g == h){
                    ans = Math.max(ans, pos[j] - pos[i]);
                } else if (g == 0 || h == 0) {
                    ans = Math.max(ans, pos[j] - pos[i]);
                }
            }
        }
        System.out.println(ans);
    }
}

