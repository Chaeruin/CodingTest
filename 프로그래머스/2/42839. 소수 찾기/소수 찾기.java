import java.util.*;
class Solution {
    public int solution(String number) {
        int answer = 0;
        
        String[] numbers = number.split("");
        boolean[] visited = new boolean[numbers.length];
        
        Set<Integer> numberPerm = new HashSet<>();
        
        for (int i = 1; i <= numbers.length; i++) {
            perm(numbers, "", visited, 0, i, numberPerm);
        }
        
        for (int num: numberPerm) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    void perm(String[] numbers, String current, boolean[] visited, int depth, int r, Set<Integer> numberPerm) {
        if (depth == r) {
            numberPerm.add(Integer.parseInt(current));
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm(numbers, current + numbers[i], visited, depth + 1, r, numberPerm);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if (n <= 1) return false;			
        for (int i = 2; i  <= Math.sqrt(n); i++) {		
            if (n % i == 0) return false;		
        }
        return true;			
    }
}