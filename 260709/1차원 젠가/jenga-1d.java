import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        StringTokenizer st;

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            arr = shift(start, end);
        }

        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] shift(int start, int end) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        for (int i = start; i <= end; i++) {
            list.remove(start);
        }

        int[] newArr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            newArr[i] = list.get(i);
        }

        return newArr;
    }
}
 