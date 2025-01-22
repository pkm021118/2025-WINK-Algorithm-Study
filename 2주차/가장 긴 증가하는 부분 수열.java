import java.util.Scanner;

public class Longest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 배열 크기 입력
        int N = scanner.nextInt();
        int[] A = new int[N];
        
        // 배열 요소 입력
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        scanner.close();
        
        // LIS 계산
        System.out.println(findLIS(A, N));
    }
    
    public static int findLIS(int[] A, int N) {
        int[] dp = new int[N];
        int maxLength = 0;

        // 모든 원소에 대해 초기값 1로 설정
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        // LIS 계산
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        // 최댓값 찾기
        for (int i = 0; i < N; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
