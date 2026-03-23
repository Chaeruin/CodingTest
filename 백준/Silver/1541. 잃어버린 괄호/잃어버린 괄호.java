import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("-");

        int result = 0;

        for (int i = 0; i < str.length; i++) {
            int tmp = 0;
            String[] add = str[i].split("\\+");
            
            for (int j = 0; j < add.length; j++) {
                tmp += Integer.parseInt(add[j]);
            }
            if (i == 0) result += tmp;
            else result -= tmp;
        }
        
        System.out.println(result);
    }
}