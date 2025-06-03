class Solution {
    public String solution(String cipher, int code) {
        String[] str = cipher.split("");
        String[] result = new String[str.length/code];
        
        for (int i = 0; i < str.length/code; i++) {
            result[i] = str[code * i + (code - 1)];
        }
        
        return String.join("", result);
    }
}