import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Integer[] nums2 = Arrays.stream(nums).boxed().toArray(Integer[] :: new);
        Set<Integer> setNums = new HashSet<>(Arrays.asList(nums2));
        if (setNums.size() <= nums.length/2) {
            answer = setNums.size();
        } else {
            answer = nums.length/2;
        }
        return answer;
    }
}