import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static int[] colors; // 색상 저장 (-1, 0, 1)
    static boolean isBipartite;

    public static void dfs(int node, int color) {
        colors[node] = color; // 현재 노드 색상 지정
        for (int next : graph.get(node)) {
            if (colors[next] == 0) { // 방문하지 않은 정점이라면
                dfs(next, -color); // 반대 색상으로 설정
            } else if (colors[next] == colors[node]) {
                isBipartite = false; // 같은 그룹이면 이분 그래프 아님
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(); // 테스트 케이스 개수

        while (K-- > 0) {
            int V = sc.nextInt(); // 정점 개수
            int E = sc.nextInt(); // 간선 개수
            graph = new ArrayList<>();
            colors = new int[V + 1];
            isBipartite = true;

            for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt(), v = sc.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u); // 무방향 그래프
            }

            for (int i = 1; i <= V; i++) {
                if (colors[i] == 0) { // 방문하지 않은 정점에서 탐색 시작
                    dfs(i, 1);
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
    }
}
