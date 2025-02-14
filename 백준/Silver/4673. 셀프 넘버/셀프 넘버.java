import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) {
        int[] arr = new int[10001];
        
        for (int i = 1; i <= 10000; i++) {
            int num = d(i);
            
            if (num <= 10000) {
                arr[num] = 1;
            }
        }
        
        for (int i = 1; i < 10000; i++) {
            if (arr[i] == 0) {
                System.out.println(i);
            }
        }
    }
    
    static int d(int num) {
        int sum = num;
        
        while(num != 0) {
            sum += num % 10;
            num /= 10;
        }
        
        return sum;
    }
}