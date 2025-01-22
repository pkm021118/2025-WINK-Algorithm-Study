import java.util.Scanner;

public class RGBStreet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 집의 수 입력
        int N = sc.nextInt();
        int[][] costs = new int[N][3]; // 비용 배열

        // 비용 입력
        for (int i = 0; i < N; i++) {
            costs[i][0] = sc.nextInt(); // 빨강 비용
            costs[i][1] = sc.nextInt(); // 초록 비용
            costs[i][2] = sc.nextInt(); // 파랑 비용
        }

        // 이전 상태를 저장하는 변수
        int prevRed = costs[0][0];
        int prevGreen = costs[0][1];
        int prevBlue = costs[0][2];

        // DP 점화식 계산
        for (int i = 1; i < N; i++) {
            int currentRed = costs[i][0] + Math.min(prevGreen, prevBlue);
            int currentGreen = costs[i][1] + Math.min(prevRed, prevBlue);
            int currentBlue = costs[i][2] + Math.min(prevRed, prevGreen);

            // 현재 상태를 이전 상태로 업데이트
            prevRed = currentRed;
            prevGreen = currentGreen;
            prevBlue = currentBlue;
        }

        // 결과 출력
        int result = Math.min(prevRed, Math.min(prevGreen, prevBlue));
        System.out.println(result);

        sc.close();
    }
}
