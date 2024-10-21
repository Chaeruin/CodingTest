import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static String command;
    static int commandInt;
    
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<Integer>();
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int i = 0;

        String[] st;

        while (i < N) {
            st = br.readLine().trim().split(" ");
            command = st[0];


            if (st.length == 2) {
                commandInt = Integer.parseInt(st[1]);
            }

            if (command.equals("push")) {
                queue.add(commandInt);
            } else if (command.equals("pop")) {
                if (queue.size() == 0) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(queue.poll());
                }
            } else if (command.equals("size")) {
                System.out.println(queue.size());
            } else if (command.equals("empty")) {
                if (queue.size() == 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (command.equals("front")) {
                if (queue.size() == 0) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(queue.peek());
                }
            } else if (command.equals("back")) {
                if (queue.size() == 0) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(commandInt);
                }
            }
            i++;
        }
    }
}
