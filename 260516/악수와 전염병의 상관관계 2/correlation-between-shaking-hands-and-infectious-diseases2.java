import java.util.*;
import java.io.*;

class Infection implements Comparable<Infection> {
    int time;
    int a;
    int b;

    public Infection(int time, int a, int b) {
        this.time = time;
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Infection i) {
        return this.time - i.time;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        boolean[] infectors = new boolean[N + 1];
        infectors[P] = true;

        int[] countArr = new int[N + 1];
        
        Infection[] iArr = new Infection[T];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            iArr[i] = new Infection(t, x, y);
        }
        Arrays.sort(iArr);

        for (int i = 0; i < T; i++) {
            if (countArr[iArr[i].a] >= K && infectors[iArr[i].b] && countArr[iArr[i].b] < K) {
                countArr[iArr[i].b]++;
            } else if (countArr[iArr[i].b] >= K && infectors[iArr[i].a] && countArr[iArr[i].a] < K) {
                countArr[iArr[i].a]++;
            } else if (countArr[iArr[i].a] >= K || countArr[iArr[i].b] >= K) continue;
            if (!infectors[iArr[i].a] && !infectors[iArr[i].b]) continue;
            if (infectors[iArr[i].a] && infectors[iArr[i].b]) {
                countArr[iArr[i].a]++;
                countArr[iArr[i].b]++;
            }
            if (infectors[iArr[i].a] && !infectors[iArr[i].b]) {
                infectors[iArr[i].b] = true;
                countArr[iArr[i].a]++;
            }
            if (infectors[iArr[i].b] && !infectors[iArr[i].a]) {
                infectors[iArr[i].a] = true;
                countArr[iArr[i].b]++;
            }
        }

    
        for (int j = 1; j <= N; j++) {
            if (infectors[j]) sb.append(1);
            else sb.append(0);
        }
    
        System.out.println(sb);
    }
}