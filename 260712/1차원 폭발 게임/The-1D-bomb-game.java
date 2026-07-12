import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        if (M == 1) {
            System.out.println(0);
            return;
        }

        while (true) {
            boolean[] exploded = new boolean[list.size()];
            boolean hasExploded = false; 

            for (int i = 0; i < list.size(); i++) {
                if (isMNeighbor(i)) {
                    int removeCount = countStraight(i);
                    for (int j = i; j < i + removeCount; j++) {
                        exploded[j] = true;
                    }
                    hasExploded = true;
                    i += (removeCount - 1);
                }
            }

            if (!hasExploded) {
                break;
            }

            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (!exploded[i]) {
                    tempList.add(list.get(i));
                }
            }
            list = tempList; 
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (int i : list) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }


    public static boolean isMNeighbor(int idx) {
        if (idx + M - 1 >= list.size()) return false;

        int target = list.get(idx);
        for (int j = 1; j < M; j++) {
            if (target != list.get(idx + j)) return false;
        }
        return true;
    }

    public static int countStraight(int idx) {
        int target = list.get(idx);
        int count = 0;
        for (int i = idx; i < list.size(); i++) {
            if (list.get(i) == target) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static List bomb(int idx) {
        List<Integer> tempList = new ArrayList<>();

        int removeStart = countStraight(idx); 
        int end = idx + removeStart - 1;

        for (int i = 0; i < list.size(); i++) {
            if (i >= idx && i <= end) {
                continue;
            }
            tempList.add(list.get(i));
        }

        return tempList;
    }
}
 