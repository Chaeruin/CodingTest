class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        k = k - n / 10 >= 0 ? k - n / 10 : 0;
        
        answer = 12000 * n + k * 2000;
        
        return answer;
    }
}