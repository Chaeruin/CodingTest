import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        for (int i = 1; i < 11; i++) {
            sc.nextInt();
            String find = sc.next();
            String input = sc.next();

            int result = 0;

            for (int j = 0; j < input.length() - find.length() + 1; j++) {
                if (input.substring(j, j + find.length()).equals(find)) {
                    result++;
                }
            }

            System.out.printf("#%d %d\n", i, result);
        }
    }
}
