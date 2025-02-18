import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            String s = input[0]; // 부분 문자열인지 확인할 문자열
            String t = input[1]; // 원본 문자열

            System.out.println(isSubsequence(s, t) ? "Yes" : "No");
        }

        sc.close();
    }

    /**
     * 문자열 s가 t의 부분 문자열인지 확인하는 함수
     * 
     * @param s 부분 문자열인지 확인할 문자열
     * @param t 원본 문자열
     * @return s가 t의 부분 문자열이면 true, 아니면 false
     */
    public static boolean isSubsequence(String s, String t) {
        int sIndex = 0, tIndex = 0;

        // t를 순회하며 s의 문자가 있는지 확인
        while (tIndex < t.length() && sIndex < s.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++; // s의 현재 문자를 찾으면 s의 다음 문자로 이동
            }
            tIndex++; // t는 항상 한 칸씩 이동
        }

        // s의 모든 문자를 순서대로 찾았다면 sIndex == s.length()가 됨
        return sIndex == s.length();
    }
}
