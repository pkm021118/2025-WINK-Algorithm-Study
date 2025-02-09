import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int infectedCount = 0; // 감염된 컴퓨터 개수

    public static void dfs(int node) {
        visited[node] = true; // 현재 노드 방문 처리

        for (int next : graph.get(node)) {
            if (!visited[next]) { // 방문하지 않은 컴퓨터라면 감염
                infectedCount++; // 감염된 개수 증가
                dfs(next); // 재귀 호출
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 컴퓨터 개수
        int M = sc.nextInt(); // 네트워크 연결 개수

        visited = new boolean[N + 1]; // 1번부터 시작하므로 N+1 크기로 설정
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); // 무방향 그래프
        }

        dfs(1); // 1번 컴퓨터에서 시작

        System.out.println(infectedCount); // 감염된 컴퓨터 수 출력 (1번 제외)
    }
}
