import java.util.Scanner;
public class Main {
    public static final int OFFSET = 1000;
    public static final int MAX_R = 2000;
    public static final int MAX_N = 100;
    
    public static int n;
    public static int[] x1 = new int[MAX_N];
    public static int[] x2 = new int[MAX_N];
    
    public static int[] checked = new int[MAX_R + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cur = 0;

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            
            if(dir == 'L') {
                x1[i] = cur - x;
                x2[i] = cur;
                cur -= x;
            }
            else {
                x1[i] = cur;
                x2[i] = cur + x;
                cur += x;
            }
            
            x1[i] += OFFSET;
            x2[i] += OFFSET;
        }

        for(int i = 0; i < N; i++)
            for(int j = x1[i]; j < x2[i]; j++)
                checked[j]++;
        
        int cnt = 0;
        for(int i = 0; i <= MAX_R; i++)
            if(checked[i] >= 2)
                cnt++;

        System.out.print(cnt);
    }
}