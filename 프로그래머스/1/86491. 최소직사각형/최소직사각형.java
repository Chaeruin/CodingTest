class Solution {
    public int solution(int[][] sizes) {
        
        int W = Integer.MIN_VALUE;
        int H = Integer.MIN_VALUE;
        
        for (int i = 0; i < sizes.length; i++) {
            int width = sizes[i][0];
            int height = sizes[i][1];
            
            if (width > height) {
                W = Math.max(W, width);
                H = Math.max(H, height);
            } else {
                W = Math.max(W, height);
                H = Math.max(H, width);
            }
        }
        
        return W * H;
    }
}