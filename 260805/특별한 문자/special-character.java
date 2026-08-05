import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        char[] arr = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        String result = "None";

        for (char c : arr) {
            if (map.get(c) == 1) {
                result = String.valueOf(c);
                break;
            }
        }

        System.out.println(result);
    }
}