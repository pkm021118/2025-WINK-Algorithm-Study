import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] result; // 선택된 숫자들을 저장하는 배열
    static boolean[] visited; // 숫자의 사용 여부 체크

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. 입력 받기
        N = sc.nextInt();
        M = sc.nextInt();
        
        result = new int[M]; // M개의 숫자를 저장할 배열
        visited = new boolean[N + 1]; // 방문 체크 배열 (1부터 N까지)

        // 2. 백트래킹 시작
        backtrack(0);

        sc.close();
    }

    /**
     * 백트래킹을 수행하는 함수
     * @param depth 현재 선택된 숫자의 개수
     */
    static void backtrack(int depth) {
        // 종료 조건: M개의 숫자를 선택한 경우 출력
        if (depth == M) {
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println(); // 줄바꿈
            return;
        }

        // 1부터 N까지의 숫자 중 하나를 선택
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // 아직 선택하지 않은 숫자인 경우
                visited[i] = true; // 방문 체크
                result[depth] = i; // 선택한 숫자 저장
                backtrack(depth + 1); // 다음 단계 진행
                visited[i] = false; // 원래 상태로 복구 (백트래킹)
            }
        }
    }
}
