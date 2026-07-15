import java.util.Scanner;
import java.util.ArrayList;

class Pair { 
    int x, y;
    public Pair(int x, int y) { 
        this.x = x; 
        this.y = y; 
    } 
}

public class Main {
    public static final int ASCII_NUM = 128;
    public static final int MAX_NUM = 100;
    
    public static int n, m, K;
    public static boolean[][] apple = new boolean[MAX_NUM + 1][MAX_NUM + 1];

    public static ArrayList<Pair> snake = new ArrayList<>();
    
    public static int[] dx = new int[]{1, -1, 0, 0};
    public static int[] dy = new int[]{0, 0, 1, -1};
    
    public static int[] mapper = new int[ASCII_NUM];
    
    public static int ans;
    
    public static boolean canGo(int x, int y) {
        return x >= 1 && y >= 1 && x <= n && y <= n;
    }
    
    public static boolean isTwisted(Pair newHead) {
        for(int i = 0; i < (int) snake.size(); i++)
            if(newHead.x == snake.get(i).x && newHead.y == snake.get(i).y)                        
                return true;                                
        
        return false; 
    }
    
    public static boolean pushFront(Pair newHead) {
        if(isTwisted(newHead) == true)                        
            return false;                                     
    
        snake.add(0, newHead);                

        return true;                                         
    }                                                         
    
    public static void popBack() {
        snake.remove(snake.size() - 1);                                    
    }
    
    public static boolean moveSnake(int nx, int ny) {
        if(apple[nx][ny] == true) {                           
            apple[nx][ny] = false;
            if(pushFront(new Pair(nx, ny)) == false)         
                return false;                                 
        }                                                     
        else {
            popBack();
            
            if(pushFront(new Pair(nx, ny)) == false)         
                return false;                                 
        }       
        
        return true;                                         
    }                                                         
    
    public static boolean move(int dir, int num) {

        while(num-- > 0) {                              
            ans++;                                  
    
            Pair head = snake.get(0); 
    
            int nx = head.x + dx[dir];          
            int ny = head.y + dy[dir];         
    
            if(canGo(nx, ny) == false)              
                return false;                       
    
            if(moveSnake(nx, ny) == false)          
                return false;                       
        }
        
        return true;                               
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mapper['D'] = 0;
        mapper['U'] = 1;
        mapper['R'] = 2;
        mapper['L'] = 3;
        
        n = sc.nextInt();
        m = sc.nextInt();
        K = sc.nextInt();
        
        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            apple[x][y] = true;
        }

        snake.add(new Pair(1, 1));

        for(int i = 0; i < K; i++) {
            char dir = sc.next().charAt(0);
            int num = sc.nextInt();

            if(move(mapper[dir], num) == false) 
                break;                         
        }

        System.out.print(ans);
    }
}
