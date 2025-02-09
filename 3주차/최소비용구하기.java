import java.util.*;

class Node implements Comparable<Node> {
    int index, cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost; // 비용이 작은 순서대로 정렬
    }
}

public class Main {
    static final int INF = 1000000000;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist; // 최소 비용 배열

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nowIdx = now.index;
            int nowCost = now.cost;

            // 기존 저장된 값보다 크면 무시
            if (dist[nowIdx] < nowCost) continue;

            for (Node next : graph.get(nowIdx)) {
                int cost = dist[nowIdx] + next.cost;
                if (cost < dist[next.index]) {
                    dist[next.index] = cost;
                    pq.add(new Node(next.index, cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 도시 개수
        int M = sc.nextInt(); // 버스 개수

        dist = new int[N + 1]; // 최단 거리 배열
        Arrays.fill(dist, INF); // 초기값 무한대로 설정

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            graph.get(u).add(new Node(v, w)); // 단방향 그래프
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        dijkstra(start);

        System.out.println(dist[end]); // 최소 비용 출력
    }
}
