import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
    
        PriorityQueue<Integer> intCount = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0 && intCount.size() == 0) {
                System.out.println(0);
            } 
            else if (n == 0 && intCount.size() != 0) {
                System.out.println(intCount.poll());
            } 
            else {
                intCount.add(n);
            }
            
        }
    }
}