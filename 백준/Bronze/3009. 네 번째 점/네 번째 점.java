
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[] x_axis = new int[3];
        int[] y_axis = new int[3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            x_axis[i] = x;
            y_axis[i] = y;
        }

        int findX = 0;
        int findY = 0;

        if (x_axis[0] == x_axis[1]) findX = x_axis[2];
        else if (x_axis[0] == x_axis[2]) findX = x_axis[1];
        else findX = x_axis[0];

        if (y_axis[0] == y_axis[1]) findY = y_axis[2];
        else if (y_axis[0] == y_axis[2]) findY = y_axis[1];
        else findY = y_axis[0];

        System.out.println(findX + " " + findY);
    }
}
