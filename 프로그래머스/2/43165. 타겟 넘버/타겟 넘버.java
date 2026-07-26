class Solution {
    
    public char[] operator = {'+', '-'};
    public int targetNumber, answer = 0;
    public int[] num;
    
    public int solution(int[] numbers, int target) {
        targetNumber = target;
        num = numbers;
        
        dfs(0, 0);
        
        return answer;
    }
    
    public void dfs(int depth, int sum) {
        if (depth == num.length) {
            if (sum == targetNumber) {
                answer++;
            }
            return;
        }
        
        for (int i = 0; i < operator.length; i++) {
            if (i == 0) sum += num[depth];
            else sum -= num[depth];
            
            dfs(depth + 1, sum);
            
            if (i == 0) sum -= num[depth];
            else sum += num[depth];
        }
    }
}