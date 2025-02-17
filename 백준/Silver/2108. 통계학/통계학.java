import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        Arrays.sort(arr);

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        int avg = (int) Math.round((double) sum / N);
        int middle = arr[N / 2];
        int range = max - min;


        System.out.println(avg);
        System.out.println(middle);
        System.out.println(findMostbind());
        System.out.println(range);
    }

    static int findMostbind() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());

        keySet.sort((o1, o2) -> {
                        int freqCompare = map.get(o2).compareTo(map.get(o1));
                        return freqCompare == 0 ? Integer.compare(o1, o2) : freqCompare;
                    });
        
        int answer = -1;
        if (N == 1) {
            answer = keySet.get(0);
        } else if (map.get(keySet.get(0)) == map.get(keySet.get(1))) {
            answer = keySet.get(0) < keySet.get(1) ? keySet.get(1) : keySet.get(0);
        } else {
            answer = keySet.get(0);
        }

        return answer;
    }
}
