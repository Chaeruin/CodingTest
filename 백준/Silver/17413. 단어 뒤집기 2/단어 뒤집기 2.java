import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean check = false; // 태그 체크

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '<') { // 태그가 시작된다면
                print(stack); // 스택에 넣었던 단어 출력
                check = true;
                System.out.print(S.charAt(i));
            } else if (S.charAt(i) == '>') {
                check = false;
                System.out.print(S.charAt(i));
            } else if (check) { // '>'오기 전가지 태그 출력
                System.out.print(S.charAt(i));
            } else { // 태그가 아닌 경우
                if (S.charAt(i) == ' ') { // 공백이라면
                    print(stack); // 전에 넣었던 단어 출력
                    System.out.print(S.charAt(i));
                } else {
                    stack.push(S.charAt(i)); // 공백이 아닌 경우 push
                }
            }
        }
        print(stack);
    }

    public static void print(Stack stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.peek());
            stack.pop();
        }
    }
}