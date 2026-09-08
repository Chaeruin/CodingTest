class Solution {
    public int[] solution(int brown, int yellow) {
        // (가로 + 세로) = brown / 2 + 2 
        // → 내부 너비 (= width) + 높이 = brown / 2 - 2
        int width = brown / 2 - 2;
        int height = 0;

        // 내부 영역이 yellow가 될 때까지 반복
        while (--width * ++height != yellow);

        // 테두리(2줄)를 더해 실제 가로/세로 반환
        return new int[] {width + 2, height + 2};
    }
}