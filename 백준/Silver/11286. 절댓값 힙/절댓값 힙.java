import java.util.*;
import java.io.*;

public class Main {
    static class absoluteInt {
        int realNum; // 실제 값
        int abNum;   // 절댓값

        public absoluteInt(int realNum, int abNum) {
            this.realNum = realNum;
            this.abNum = abNum;
        }
    }

    static class absoluteComparator implements Comparator<absoluteInt> {

        @Override
        public int compare(absoluteInt o1, absoluteInt o2) {
            // o1 : -2 / o2 : -1   // o1 : 2 / o2 : 1
            if (o1.abNum > o2.abNum) {
                return 1;
            } 
            // o1 : -1 / o2 : 2  
            else if (o1.abNum < o2.abNum && o1.realNum < o2.realNum) {
                return -1;
            }
            // o1 : 1 / o2 : -2
            else if (o1.abNum < o2.abNum && o1.realNum > o2.realNum) {
                return -1;
            }
            // o1 : -1 / o2 : 1
            else if (o1.abNum == o2.abNum && o1.realNum < o2.realNum){
                return -1;
            }
            // o1 : 1 / o2 : -1
            else if (o1.abNum == o2.abNum && o1.realNum > o2.realNum){
                return 1;
            }
            return 0;
        }
    }

    public static void main (String[] args) throws NumberFormatException, IOException {
        PriorityQueue<absoluteInt> abQueue = new PriorityQueue<>(2, new absoluteComparator());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (abQueue.size() == 0) {
                    System.out.println(0);
                }
                else {
                    System.out.println(abQueue.poll().realNum);
                }
            }
            else {
                abQueue.add(new absoluteInt(input, Math.abs(input)));
            }
        }
    }
}
