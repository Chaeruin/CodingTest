import java.io.*;
import java.util.*;

class Node {
        String data;
        Node prev, next;

        public Node(String data) { 
            this.data = data;
            this.prev = this.next = null;
        }
    }

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        Node cur = new Node(str);
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                String val = st.nextToken();
                Node newNode = new Node(val);
                insertPrev(cur, newNode);
            } else if (command == 2) {
                String val = st.nextToken();
                Node newNode = new Node(val);
                insertNext(cur, newNode);
            } else if (command == 3) {
                if (isPrev(cur)) cur = cur.prev;
            } else if (command == 4) {
                if (isNext(cur)) cur = cur.next;
            }

            System.out.print(cur.prev == null ? "(Null) " : cur.prev.data + " ");
            System.out.print(cur.data + " ");
            System.out.println(cur.next == null ? "(Null)" : cur.next.data);
        }

    }

    static void insertPrev (Node u, Node singleton) {
        singleton.next = u;
        singleton.prev = u.prev;
    
        if (null != singleton.prev)
            singleton.prev.next = singleton;
        if (null != singleton.next)
            singleton.next.prev = singleton;
    }

    static void insertNext(Node u, Node singleton) {
        singleton.prev = u;
        singleton.next = u.next;
        
        if (null != singleton.prev)
            singleton.prev.next = singleton;
        if (null != singleton.next)
            singleton.next.prev = singleton;
    }

    static boolean isPrev (Node cur) {
        if (cur.prev != null) return true;
        return false;
    }

    static boolean isNext (Node cur) {
        if (cur.next != null) return true;
        return false;
    }
}
 