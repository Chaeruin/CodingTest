

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        StringBuilder sb = new StringBuilder();
        while (!(input = br.readLine()).equals(".")) {
            Stack<String> stack = new Stack<>();
            String[] inputArr = input.split("");
            boolean isError = false; 

            for (int i = 0; i < inputArr.length; i++) {
                if (inputArr[i].equals("(") || inputArr[i].equals("[")) {
                    stack.push(inputArr[i]);
                }
                else if (inputArr[i].equals(")")) {
                    if (stack.isEmpty() || !stack.peek().equals("(")) {
                        isError = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
                else if (inputArr[i].equals("]")) { 
                    if (stack.isEmpty() || !stack.peek().equals("[")) {
                        isError = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!isError && stack.isEmpty()) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }

        System.out.println(sb);
    }
}
