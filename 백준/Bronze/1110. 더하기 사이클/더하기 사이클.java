import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strNum = br.readLine();
        int number = Integer.parseInt(strNum);

        String[] strNums = strNum.split("");
        int leftNum = Integer.parseInt(strNums[0]);
        int rightNum = 0;
        try {
            rightNum = Integer.parseInt(strNums[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            leftNum = 0;
            rightNum = Integer.parseInt(strNums[0]);
        }

        int count = 0, newInt = 100;
        
        while (number != newInt) {
            int newNum = leftNum + rightNum;
            String newLeft = Integer.toString(rightNum);
            String newRight = Integer.toString(newNum % 10);
            
            String newNumber = newLeft + newRight;
            leftNum = rightNum;
            rightNum = Integer.parseInt(newRight);
            newInt = Integer.parseInt(newNumber);
            count++;
        }

        System.out.println(count);
    }
}
