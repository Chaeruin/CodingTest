import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Member> list = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Member(age, name));
        }

        Collections.sort(list, (Member member1, Member member2) -> {
            for (int i = 0; i < list.size() - 1; i++){
                if (member1.age == member2.age){
                    return member1.index - member2.index;
                }
            }
            return member1.age - member2.age;
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++){
            sb.append(list.get(i).age).append(" ").append(list.get(i).name).append("\n");
        }

        System.out.println(sb);
    }
}

class Member {
    int index = 0;
    int age;
    String name;

    public Member () {}

    public Member (int age, String name) {
        this.age = age;
        this.name = name;
        this.index++;
    }
}
