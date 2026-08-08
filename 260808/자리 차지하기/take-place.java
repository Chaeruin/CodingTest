import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        TreeSet<Integer> seats = new TreeSet<>();

        for(int i = 1; i <= m; i++)
            seats.add(i);

        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(seats.floor(arr[i]) != null) {
                int num = seats.floor(arr[i]);
                seats.remove(num);
                
                ans++;
            }
            else
                break;
        }

        System.out.print(ans);
    }
}