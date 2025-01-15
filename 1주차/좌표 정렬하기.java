import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력을 받기 위해 Scanner 객체 생성

        // 점의 개수 입력받기
        int n = scanner.nextInt();

        // 점의 좌표를 저장할 2차원 배열 생성
        int[][] points = new int[n][2];

        // 점의 좌표를 입력받아 배열에 저장
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt(); // x 좌표 입력
            points[i][1] = sc.nextInt(); // y 좌표 입력
        }

        // 점들을 정렬
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) { // 두 점의 x 좌표가 같으면 y 좌표를 기준으로 비교
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]); // 아니면 x 좌표를 기준으로 비교
        });

        // 정렬된 점 출력
        for (int i = 0; i < n; i++) {
            System.out.println(points[i][0] + " " + points[i][1]);
        }
    }
}
