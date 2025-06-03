import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Arrays.sort(numbers);
        int N = numbers.length;
        
        if (numbers[1] < 0) {
            answer = numbers[0] * numbers[1] > numbers[N - 1] * numbers[N - 2] ? numbers[0] * numbers[1] : numbers[N - 1] * numbers[N - 2];
        } else {
            answer = numbers[N - 1] * numbers[N - 2];
        }
        
        return answer;
    }
}