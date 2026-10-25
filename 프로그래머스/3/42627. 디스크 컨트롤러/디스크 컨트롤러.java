import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        
        int[][] sorted = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            sorted[i] = new int[] {jobs[i][0], jobs[i][1], i};
        }
        
        Arrays.sort(sorted, 
            (a, b) -> Integer.compare(a[0], b[0])
        );
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[2], b[2]);
        });
        
        int time = 0;
        int index = 0;
        int completed = 0;
        int total = 0;
        
        while (completed < n) {
            while (index < n && sorted[index][0] <= time) {
                pq.add(sorted[index]);
                index++;
            }
            
            if (pq.isEmpty()) {
                time = sorted[index][0];
                continue;
            }
            
            int[] job = pq.poll();
            
            time += job[1]; // 현재 시간 + 작업 소요시간 = 작업 후 현재 시간
            total += (time - job[0]); // 반환 시간 총합 = 작업 후 현재 시간 - 작업 요청 시간
            
            completed++;
        }
        
        return total / n;
    }
}

// jobs[작업 번호] = [작업 들어오는 시간, 작업 소요 시간]
// 작업 들어오는 시간에 대기 큐에 들어옴
// 대기큐에서 작업 시작할 때의 우선순위
//      1. 작업 소요시간이 짧은 거
//      2. 작업 들어오는 시간이 빠른거
//      3. 작업 번호가 작은거
// 현재 시간보다 빠른 시간에 작업 들어오는 시간인 것은 대기큐에 한번에 저장
// job을 꺼내고 time에 소요 시간 ++
//  반환 시간 총합을 의미하는 total += (time{작업끝난 시간이라는 뜻}) - 작업 들어오는 시간