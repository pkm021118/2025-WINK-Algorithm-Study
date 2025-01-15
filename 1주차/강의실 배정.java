import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 강의 수 입력
        int n = sc.nextInt();
        int[][] lectures = new int[n][2];

        // 강의 시간 입력
        for (int i = 0; i < n; i++) {
            lectures[i][0] = sc.nextInt(); // 시작 시간
            lectures[i][1] = sc.nextInt(); // 종료 시간
        }

        // 강의 시작 시간을 기준으로 정렬
        Arrays.sort(lectures, (a, b) -> Integer.compare(a[0], b[0]));

        // 우선순위 큐를 이용해 강의실 종료 시간을 관리
        PriorityQueue<Integer> roomEndTimes = new PriorityQueue<>();

        for (int[] lecture : lectures) {
            // 가장 빨리 끝나는 강의실의 종료 시간 확인
            if (!roomEndTimes.isEmpty() && roomEndTimes.peek() <= lecture[0]) {
                roomEndTimes.poll(); // 해당 강의실을 재사용 가능하므로 종료 시간 제거
            }
            // 현재 강의의 종료 시간을 강의실에 추가
            roomEndTimes.add(lecture[1]);
        }

        // 큐에 남아있는 종료 시간의 개수가 필요한 강의실 수
        System.out.println(roomEndTimes.size());
    }
}
