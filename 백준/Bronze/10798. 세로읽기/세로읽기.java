import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> strings = new ArrayList<>();

        try {
            String str;

            while ((str = br.readLine()) != null) {
                strings.add(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        List<String> result = new ArrayList<>();
        int i = 0;
        
        List<Integer> length = new ArrayList<>();
        for (String s : strings) {
            length.add(s.length());
        }
        Integer maxLength = Collections.max(length);

        while (i <= maxLength){
            for (String str : strings) {
                if (str.length() <= i) {
                    continue;
                }
                result.add(String.valueOf(str.charAt(i)));
            }
            i++;
        }

        String answer = String.join("",result);
        System.out.println(answer);
    }
}