import java.io.*;
import java.util.*;

public class Main {

    static int N, B;
    static int[] arrP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arrP = new int[N];

        for (int i = 0; i < N; i++) {
            arrP[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arrP);

        int maxStudentsCount = 0;


        for (int i = 0; i < N; i++) {

            int maxPeopleCount = 0;
            int currentBudget = B;

            for (int j = 0; j < N; j++) {
                int sum = 0;
                int cost = arrP[j];

                if (i == j) cost /= 2;

                if (currentBudget >= cost) {
                    currentBudget -= cost;
                    maxPeopleCount++;
                }
                else break;
            }

            maxStudentsCount = Math.max(maxStudentsCount, maxPeopleCount);
        }

        System.out.println(maxStudentsCount);
    }
}



