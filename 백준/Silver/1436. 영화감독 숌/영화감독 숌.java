import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int number = 666;
        int count = 1;

        while (count != N) {
            number++;
            if (String.valueOf(number).contains("666")) {
                count++;
            }
        }
        System.out.println(number);
    }
}