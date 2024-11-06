import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String A = "AAAA";
	    String B = "BB";
	    
	    String s = br.readLine();
	    
	    s = s.replace("XXXX",A); ////s = s.replaceAll("XXXX", "AAAA");
	    s = s.replace("XX",B);
	    
        if(s.contains("X")){
            System.out.println(-1);
        }else
	        System.out.println(s);
	    
	}
}