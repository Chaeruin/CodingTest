import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        
        long left = 1;                         
        long right = 2_000_000_000;                     
        long maxNum = 0;                     
        while (left <= right) {            
            long mid = (left + right) / 2;      
            if(mid * (mid + 1) / 2 <= s) {   
                left = mid + 1;              
                maxNum = Math.max(maxNum, mid);
            }
            else                               
                right = mid - 1;               
        }

        System.out.print(maxNum);             
    }
}
