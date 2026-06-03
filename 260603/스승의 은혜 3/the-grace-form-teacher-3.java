import java.io.*;
import java.util.*;

public class Main {

    static int N, B;
    static int[][] presentPrice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        presentPrice = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            presentPrice[i][0] = Integer.parseInt(st.nextToken());
            presentPrice[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(presentPrice, (o1, o2) -> {
            return Integer.compare(o1[0] + o1[1], o2[0] + o2[1]);
        });

        int maxCount = 0;

        for (int i = 0; i < N; i++) {
            
            int maxPeopleCount = 0;
            int currentBudget = B;

            for (int j = 0; j < N; j++) {
                int sum = 0;
                int cost = presentPrice[j][0];

                if (i == j) cost = cost / 2 + presentPrice[j][1];
                else cost += presentPrice[j][1];

                if (currentBudget >= cost) {
                    currentBudget -= cost;
                    maxPeopleCount++;
                }
            }

            maxCount = Math.max(maxCount, maxPeopleCount);
        }

        System.out.println(maxCount);
    }
}



