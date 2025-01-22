import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ToOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        System.out.println(minOperations(N));
    }

    public static int minOperations(int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n + 1];

        queue.add(n);
        visited[n] = 1; // 방문 처리 및 연산 횟수 기록

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == 1) {
                return visited[current] - 1; // 결과 반환
            }

            // 3으로 나눌 수 있는 경우
            if (current % 3 == 0 && visited[current / 3] == 0) {
                queue.add(current / 3);
                visited[current / 3] = visited[current] + 1;
            }

            // 2로 나눌 수 있는 경우
            if (current % 2 == 0 && visited[current / 2] == 0) {
                queue.add(current / 2);
                visited[current / 2] = visited[current] + 1;
            }

            // 1을 뺄 수 있는 경우
            if (current - 1 > 0 && visited[current - 1] == 0) {
                queue.add(current - 1);
                visited[current - 1] = visited[current] + 1;
            }
        }

        return -1;
    }
}
