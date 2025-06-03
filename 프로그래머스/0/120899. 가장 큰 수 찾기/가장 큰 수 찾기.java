class Solution {
    public int[] solution(int[] array) {
        int max = -1;
        int index = -1;
        
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                index = i;
            }
        }
        
        return new int[] {max, index};
    }
}