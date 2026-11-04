class Solution {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n, m;
        
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        n = park.length;
        m = park[0].length();
        
        int x = getStart(park)[0];
        int y = getStart(park)[1];
        
        for (int i = 0; i < routes.length; i++) {
            String[] dirCount = routes[i].split(" ");
            
            String dir = dirCount[0];
            int count = Integer.parseInt(dirCount[1]);
            
            int dirIdx = getIdx(dir);
            int nx = x + count * dx[dirIdx];
            int ny = y + count * dy[dirIdx];
            
            if (!inRange(nx, ny)) continue;
            
            int tx = x;
            int ty = y;

            boolean isObst = false;

            for (int j = 1; j <= count; j++) {
                tx += dx[dirIdx];
                ty += dy[dirIdx];

                if (park[ty].charAt(tx) == 'X') {
                    isObst = true;
                    break;
                }
            }
            
            if (isObst) continue;
            
            x = nx;
            y = ny;
        }
        
        answer[0] = y;
        answer[1] = x;
        
        return answer;
    }
    
    public int[] getStart(String[] park) {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                if (park[i].charAt(j) == 'S') return new int[] {j, i};
            }
        }
        
        return new int[] {-1, -1};
    }
    
    public boolean inRange(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    
    public int getIdx(String dir) {
        if (dir.equals("N")) return 0;
        if (dir.equals("S")) return 1;
        if (dir.equals("W")) return 2;
        if (dir.equals("E")) return 3;
        return -1;
    }
}

// 길 O / 장애물 X
// 벗어나거나 장애물 시 다음 루트 수행
