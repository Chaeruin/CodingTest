import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        
        for (int i = 0; i < N; i++) {
            if (isGroupString(br.readLine())) {
                count++;
            }
        }
        
        System.out.println(count);
    }
    
    static boolean isGroupString(String str) {
        boolean[] alpha = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);
            int prev = (i > 0) ? str.charAt(i - 1) : 0;
            
            if (!alpha[now - 'a']) {
                alpha[now - 'a'] = true;
            } else if (now != prev) {
                return false;
            }
        }
        return true;
    }
}