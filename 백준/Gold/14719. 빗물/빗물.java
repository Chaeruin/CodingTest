import java.io.*;
import java.util.*;

public class Main {

    static int H, W;
    static int[] rainFall;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        rainFall = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            rainFall[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < W - 1; i++){
            int left = 0, right = 0;
            //좌측 블럭 최대 높이 구하기
            for(int j = 0; j < i; j++)
                left = Math.max(left, rainFall[j]);
            //우측 블럭 최대 높이 구하기
            for(int j = i + 1; j < W; j++)
                right = Math.max(right, rainFall[j]);
            
            //현재 열 블럭이 좌측, 우측 블럭보다 작을 때
            if(rainFall[i] < left && rainFall[i] < right){
                //고인 빗물 계산
                answer += Math.min(left, right) - rainFall[i];
            }
        }
        
        System.out.println(answer);
    }
}
