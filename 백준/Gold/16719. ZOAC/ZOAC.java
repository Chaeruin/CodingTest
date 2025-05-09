import java.util.*;
import java.io.*;
public class Main {
    static boolean[] check;
    static String s;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s = sc.nextLine();
        check = new boolean[s.length()];
        print(0, s.length()-1);
        bw.flush();
        bw.close();
        sc.close();
    }
    public static void print(int start, int end) throws IOException{
        //문자
        int comp = Integer.MAX_VALUE;
        //위치
        int index = -1;
        //최솟값 탐색
        for(int i = start; i <= end; i++){
            if(!check[i] && comp > s.charAt(i)){
                comp = s.charAt(i);
                index = i;
            }
        }
        if(comp == Integer.MAX_VALUE)
            return;

        check[index] = true;
        for(int i = 0; i < s.length(); i++){
            if(check[i]){
                bw.write(s.charAt(i));
            }
        }
        bw.write('\n');
        print(index + 1, end);
        print(start, index - 1);
    }
}