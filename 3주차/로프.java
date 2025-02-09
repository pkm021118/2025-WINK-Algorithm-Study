import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 로프 개수
        int[] ropes = new int[N];

        for (int i = 0; i < N; i++) {
            ropes[i] = sc.nextInt(); // 각 로프가 버틸 수 있는 최대 중량 입력
        }

        // 오름차순 정렬 (가장 작은 로프부터)
        // 작은 로프부터 시작하여 현재 로프와 뒤의 모든 로프를 함께 사용했을 때의 최적 중량을 계산하기 위해서
        Arrays.sort(ropes);

        int maxWeight = 0;

        // 각 로프를 포함할 때 최대 중량 계산
        for (int i = 0; i < N; i++) {
            // (현재 로프 중량 × 사용 가능한 로프 개수)
            // i번째 로프를 사용할 경우 그 뒤에 있는 모든 로프도 함께 사용해도 최대 중량은 변하지 않음
            int weight = ropes[i] * (N - i); 
            
            // 최댓값 갱신
            maxWeight = Math.max(maxWeight, weight); 
        }

        // 최적의 최대 중량을 출력
        System.out.println(maxWeight);
    }
}
