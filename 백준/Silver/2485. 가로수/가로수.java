
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] tree = new int[N];

        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        int gcd = 0;

        for(int i = 0; i < N - 1; i++){
            int distance = tree[i + 1] - tree[i];
            gcd = findGCD(distance, gcd);
        }

        int count = (tree[N - 1] - tree[0]) / gcd + 1 - tree.length;

        System.out.println(count);
    }

    static int findGCD(int A, int B){
        while(B != 0){
            int R = A%B;
            A = B;
            B = R;
        }
        return A;
    }
}
