import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //문서 입력
        String document = sc.nextLine();

        //검색할 단어 입력
        String word = sc.nextLine();

        sc.close();

        // 중복되지 않게 등장하는 최대 횟수 출력
        System.out.println(countNonOverlappingOccurrences(document, word));
    }

    /**
     * 주어진 문자열에서 특정 패턴이 겹치지 않게 몇 번 등장하는지 계산하는 함수
     * 
     * @param text    검색할 문서
     * @param pattern 찾고 싶은 단어
     * @return 중복 없이 등장하는 최대 횟수
     */
    public static int countNonOverlappingOccurrences(String text, String pattern) {
        int count = 0; // 중복 없이 등장하는 단어의 개수
        int index = 0; // 현재 탐색 시작 위치

        // text.indexOf(pattern, index)를 사용하여 pattern을 찾음
        // pattern을 찾으면 해당 위치(index)를 반환하고, 찾지 못하면 -1을 반환
        while ((index = text.indexOf(pattern, index)) != -1) {
            count++; // 패턴이 발견될 때마다 카운트 증가
            index += pattern.length(); // 중복을 피하기 위해 패턴 길이만큼 index 이동
        }

        return count; // 최종적으로 찾은 패턴의 개수 반환
    }
}
