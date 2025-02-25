import java.util.Scanner;

public class Main {
    static final int INF = 1_000_000_000;
    static int N; // 도시 개수
    static int[][] W; // 비용 행렬
    static int[][] dp; // DP 테이블 (현재 도시, 방문 상태)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        W = new int[N][N];
        dp = new int[N][1 << N]; // dp[current][visited] 형태 (2^N 크기)

        // 비용 행렬 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                W[i][j] = sc.nextInt();
            }
        }

        // DP 테이블 초기화 (모두 -1로 설정)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < (1 << N); j++) {
                dp[i][j] = -1;
            }
        }

        // 0번 도시에서 시작하여 모든 도시 방문 후 돌아오는 최소 비용 계산
        int result = tsp(0, 1);

        System.out.println(result);
    }

    /**
     * 외판원 순회 (TSP) 문제를 해결하는 DP + 비트마스크 재귀 함수
     * @param current 현재 위치한 도시
     * @param visited 현재까지 방문한 도시를 나타내는 비트마스크
     * @return 최소 비용
     */
    static int tsp(int current, int visited) {
        // 모든 도시 방문 완료한 경우 (출발 도시로 돌아갈 수 있는지 확인)
        if (visited == (1 << N) - 1) {
            return (W[current][0] == 0) ? INF : W[current][0]; // 갈 수 없으면 INF 반환
        }

        // 이미 계산된 경우 반환
        if (dp[current][visited] != -1) {
            return dp[current][visited];
        }

        dp[current][visited] = INF; // 최소 비용을 구하기 위해 초기값을 크게 설정

        // 모든 도시를 탐색하며 다음 경로 찾기
        for (int next = 0; next < N; next++) {
            // 이미 방문한 도시이거나, 갈 수 없는 경우 스킵
            if ((visited & (1 << next)) != 0 || W[current][next] == 0) {
                continue;
            }

            // 다음 도시 방문 상태 업데이트
            int newVisited = visited | (1 << next);
            int cost = tsp(next, newVisited) + W[current][next];

            // 최소 비용 갱신
            dp[current][visited] = Math.min(dp[current][visited], cost);
        }

        return dp[current][visited];
    }
}
