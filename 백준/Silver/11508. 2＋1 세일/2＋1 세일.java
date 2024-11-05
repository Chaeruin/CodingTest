import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] items = new Integer[N];

        for (int i = 0; i < N; i++) {
            items[i] = Integer.parseInt(br.readLine());
        }

        int minimumCost = 0;

        Arrays.sort(items, Comparator.reverseOrder());


        for (int i = 0; i < N; i += 3) {
            minimumCost += items[i]; 
            if (i + 1 < N) minimumCost += items[i + 1]; 
            // 세 번째 아이템은 무료이므로 추가하지 않음
        }


        System.out.println(minimumCost);
    }
}