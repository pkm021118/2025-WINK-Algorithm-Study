import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        sc.close();

        // LCS 길이 계산
        int lcsLength = findLCSLength(s1, s2);

        System.out.println(lcsLength);
    }

    /**
     * 두 문자열 s1과 s2의 LCS(최장 공통 부분 수열)의 길이를 구하는 함수
     * @param s1 첫 번째 문자열
     * @param s2 두 번째 문자열
     * @return LCS 길이
     */
    public static int findLCSLength(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        // DP 테이블 생성 (0으로 초기화됨)
        int[][] dp = new int[len1 + 1][len2 + 1];

        // DP 진행
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // 문자가 같으면 LCS 증가
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 다르면 이전 단계의 최댓값 사용
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 최종 LCS 길이 반환
        return dp[len1][len2];
    }
}
