import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 학생 수 입력받기
        int n = sc.nextInt();
        sc.nextLine();

        // 학생 정보를 저장 리스트 생성
        List<Student> students = new ArrayList<>();

        // 학생 정보 리스트 추가
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            students.add(new Student(
                input[0],
                Integer.parseInt(input[1]),
                Integer.parseInt(input[2]),
                Integer.parseInt(input[3])
            ));
        }

        // 학생 정렬 및 출력
        students.sort((a, b) -> {
            if (a.korean != b.korean) return b.korean - a.korean;
            if (a.english != b.english) return a.english - b.english;
            if (a.math != b.math) return b.math - a.math;
            return a.name.compareTo(b.name);
        });

        for (Student s : students) {
            System.out.println(s.name);
        }
    }
}

// 학생 정보 클래스
class Student {
    String name;
    int korean;
    int english;
    int math;

    Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
}
