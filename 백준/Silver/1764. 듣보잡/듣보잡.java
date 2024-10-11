import java.io.*;
import java.util.*;


public class Main {
    static int cnt = 0;
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        HashSet<String> listen = new HashSet<>();
        HashSet<String> look = new HashSet<>();

        String str;
        int i = 0, j = 0;
        while (i < n) {
            str = br.readLine();
            listen.add(str);
            i++;
        }
        while (j < m) {
            str = br.readLine();
            look.add(str);
            j++;
        }

        HashSet<String> listlook = new HashSet<>();
        listen.forEach(s1 -> {
                if (look.contains(s1)) {
                    Main.cnt++;
                    listlook.add(s1);
                }
            }
        );

        System.out.println(cnt);
        listlook.stream().sorted().forEach(item -> System.out.println(item));
    }
}
