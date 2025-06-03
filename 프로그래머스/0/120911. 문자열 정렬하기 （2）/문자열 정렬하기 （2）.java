import java.util.*;

class Solution {
    public String solution(String my_string) {
        my_string = my_string.toLowerCase();
        
        String[] str = my_string.split("");
        Arrays.sort(str);
        
        return String.join("", str);
    }
}