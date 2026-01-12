import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        double totalCredit = 0.0;
        double totalGrade = 0.0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            double grade = getGradeDouble(st.nextToken());

            if (grade == -1) continue;
            totalCredit += credit;
            totalGrade += (grade * credit);
        }

        System.out.println(totalGrade / totalCredit);
    }

    public static double getGradeDouble(String grade) {
        if (grade.equals("A+")) return 4.5;
        else if (grade.equals("A0")) return 4.0;
        else if (grade.equals("B+")) return 3.5;
        else if (grade.equals("B0")) return 3.0;
        else if (grade.equals("C+")) return 2.5;
        else if (grade.equals("C0")) return 2.0;
        else if (grade.equals("D+")) return 1.5;
        else if (grade.equals("D0")) return 1.0;
        else if (grade.equals("F")) return 0.0;
        else if (grade.equals("P")) return -1;
        return -1;
    }
}

