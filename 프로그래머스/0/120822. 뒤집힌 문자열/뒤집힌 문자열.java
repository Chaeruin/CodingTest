class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] myStr = my_string.split("");
        for (int i = 0; i < myStr.length / 2; i++) {
            String tmp = myStr[i];
            myStr[i] = myStr[myStr.length - 1 - i];
            myStr[myStr.length - 1 - i] = tmp;
        }
        
        return String.join("", myStr);
    }
}