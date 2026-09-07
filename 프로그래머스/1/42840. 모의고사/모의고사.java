import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        
        int[] answerA = {1, 2, 3, 4, 5}; // 4
        int[] answerB = {2, 1, 2, 3, 2, 4, 2, 5}; // 7
        int[] answerC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 9
        
        int countOne = 0;
        int countTwo = 0;
        int countThree = 0;
        
        for (int i = 0; i < answers.length; i++) {
            int indexA = i % 5;
            int indexB = i % 8;
            int indexC = i % 10;
            
            if (answerA[indexA] == answers[i]) countOne++;
            if (answerB[indexB] == answers[i]) countTwo++;
            if (answerC[indexC] == answers[i]) countThree++;
        }
        
        int max = Math.max(countOne, Math.max(countTwo, countThree));
        
        if (max == countOne) list.add(1);
        if (max == countTwo) list.add(2);
        if (max == countThree) list.add(3);
        
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        
        return arr;
    }
}