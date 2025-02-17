import java.util.*;
import java.io.*;

class Main {

    static int count = 0;
    static String[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().split("");

        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            map.put(input[i], map.getOrDefault(input[i], 0) + 1);
        }

        int sixNineSet = (map.getOrDefault("6", 0) + map.getOrDefault("9", 0) + 1) / 2;

        map.remove("6");
        map.remove("9");
        
        int maxValue = sixNineSet;
        for (int count : map.values()) {
            maxValue = Math.max(maxValue, count);
        }

        System.out.println(maxValue);

    }
}