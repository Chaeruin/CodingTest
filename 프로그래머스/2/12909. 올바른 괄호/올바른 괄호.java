import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> rhkfgh = new Stack<>();
        char[] strs = s.toCharArray();
        int openCount = 0;
        
        for (char str : strs) {
            rhkfgh.push(str);
        }
        
        if (rhkfgh.peek() == '(') {
            answer = false;
            return answer;
        }
        
        while (!rhkfgh.isEmpty()) {
            char rhkf = rhkfgh.pop();
            
            if (rhkf == '(') {
                openCount++;
            } else if (rhkf == ')') {
                openCount--;
            }
            if (openCount > 0) {
                answer = false;
                return answer;
            }
        }
        
        if (openCount != 0) {
            answer = false;
        }

        return answer;
    }
}