import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = board.length, m = board[0].length;

        
        int[] topRow = IntStream.range(0, m)
                                  .map(i -> IntStream.range(0, n)
                                                     .filter(j -> board[j][i] != 0)
                                                     .findFirst()
                                                     .orElse(n))
                                  .toArray();
        
        Stack<Integer> stack = new Stack<>();
        
        int countPop = 0; 

        for (int move : moves) {
            int col = move - 1; 

            if (topRow[col] >= n) continue;

            if (!stack.isEmpty() && stack.peek() == board[topRow[col]][col]) {
                stack.pop();
                countPop += 2;
            }
            else {
                stack.add(board[topRow[col]][col]);
            }

            topRow[col]++;
        }

        return countPop;
    }
}