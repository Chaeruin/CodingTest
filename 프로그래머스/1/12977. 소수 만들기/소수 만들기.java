class Solution {
    public int solution(int[] nums) {
        return dfs(0, -1, 0, nums);
    }

    public int dfs(int sum, int index, int depth, int[] nums) {
        if (depth == 3) return isPrime(sum) ? 1 : 0;

        int count = 0;
        for (int i = index + 1; i < nums.length; i++) {
            count += dfs(sum + nums[i], i, depth + 1, nums);
        }

        return count;
    }

    
    public boolean isPrime(int num) {
        if (num == 2) return true;
        if (num <= 1 || num % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }

        return true;
    }

}