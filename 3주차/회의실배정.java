import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 회의 개수
        int[][] meetings = new int[N][2]; // 회의 정보 (시작 시간, 끝나는 시간)

        for (int i = 0; i < N; i++) {
            meetings[i][0] = sc.nextInt(); // 시작 시간
            meetings[i][1] = sc.nextInt(); // 끝나는 시간
        }

        // 끝나는 시간 기준으로 오름차순 정렬
        // 만약 끝나는 시간이 같다면, 시작 시간이 빠른 순으로 정렬
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1])
                return a[0] - b[0]; // 끝나는 시간이 같으면 시작 시간 기준 정렬
            return a[1] - b[1]; // 끝나는 시간이 빠른 순서로 정렬
        });

        int count = 0; // 최대 사용할 수 있는 회의 개수
        int endTime = 0; // 현재까지 선택한 회의 중 가장 늦게 끝난 시간

        // 회의 선택
        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= endTime) { // 현재 회의의 시작 시간이 이전 회의 종료 시간 이후면 선택 가능
                count++;
                endTime = meetings[i][1]; // 현재 회의가 끝나는 시간 갱신
            }
        }

        System.out.println(count); // 최대 사용할 수 있는 회의 개수 출력
    }
}
