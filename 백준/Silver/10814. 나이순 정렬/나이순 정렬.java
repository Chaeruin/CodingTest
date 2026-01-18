
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Member {
    int age;
    String name;

    public Member(int a, String n){
        age = a;
        name = n;
    }
}

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Member[] arr = new Member[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Member m = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
            arr[i] = m;
        }

        Arrays.sort(arr, new Comparator<Member>() {
            public int compare(Member m1, Member m2){
                return m1.age - m2.age;
            }
        } );

        for(int i = 0; i < N; i++){
            bw.write(arr[i].age+" "+arr[i].name+"\n");
        }

        bw.flush();
        bw.close();
    }
}

