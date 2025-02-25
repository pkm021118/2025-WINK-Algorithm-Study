import java.util.*;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4]; // 연산자 개수 저장 (+, -, *, / 순서)
    static int maxValue = Integer.MIN_VALUE; // 최댓값 저장 변수
    static int minValue = Integer.MAX_VALUE; // 최솟값 저장 변수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 숫자 개수 입력
        N = sc.nextInt();
        numbers = new int[N];

        // 2. 숫자 배열 입력
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        // 3. 연산자 개수 입력 (+, -, *, / 순서)
        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        // 4. 백트래킹을 사용하여 가능한 모든 연산 조합 탐색 시작
        backtrack(numbers[0], 1);
        
        // 5. 최댓값과 최솟값 출력
        System.out.println(maxValue);
        System.out.println(minValue);
    }

    /**
     * 백트래킹을 통해 가능한 모든 연산 순서를 탐색
     * param result 현재까지 계산된 값
     * param index 다음 숫자의 인덱스
     */
    static void backtrack(int result, int index) {
        // 종료 조건: 모든 숫자를 다 사용했을 때 최댓값, 최솟값 갱신
        if (index == N) {
            maxValue = Math.max(maxValue, result);
            minValue = Math.min(minValue, result);
            return;
        }

        // 4개의 연산자 중 사용 가능한 연산자 탐색
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) { // 해당 연산자가 남아있을 경우
                operators[i]--; // 연산자 사용
                int nextResult = calculate(result, numbers[index], i); // 연산 수행
                backtrack(nextResult, index + 1); // 다음 숫자로 이동
                operators[i]++; // 연산자 복구 (백트래킹)
            }
        }
    }

    /**
     * 두 숫자와 연산자를 받아서 연산을 수행하는 함수
     * param a 이전까지의 계산 결과
     * param b 새롭게 추가할 숫자
     * param operator 연산자 종류 (0: +, 1: -, 2: *, 3: /)
     * return 연산 결과
     */
    static int calculate(int a, int b, int operator) {
        switch (operator) {
            case 0: return a + b; // 덧셈
            case 1: return a - b; // 뺄셈
            case 2: return a * b; // 곱셈
            case 3: return a / b; // 나눗셈
            default: return 0;
        }
    }
}
