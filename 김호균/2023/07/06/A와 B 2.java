import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder S = new StringBuilder(sc.nextLine());
        StringBuilder T = new StringBuilder(sc.nextLine());

        Queue<StringBuilder> q = new ArrayDeque<>();
        q.add(T);

        /* S 뒤에 B를 붙이고 뒤집은 문자열이나 A를 붙인 문자열을 T와 비교하는 것보다.
         * T 첫 문자가 B이면 이를 제거하고 뒤집은 문자열이나 A를 제거한 문자열을 S와 비교하는 것이 횟수가 적다.
         * T를 줄이는 경우는 첫 문자가 B가 아니면 연산 한 번을 안 해도 되지만
         * S를 줄이는 경우는 항상 두 가지를 수행해야 한다.
         * 따라서 T를 줄여나가며 해결한다. */
        while (!q.isEmpty()) {
            StringBuilder curT = q.poll();

            if (curT.length() < S.length()) {
                continue;
            }

            if (curT.toString().contentEquals(S)) {
                System.out.println(1);
                sc.close();
                return;
            }

            // T 첫 글자가 B이면 S 기준으로 뒤에 B를 붙이고 뒤집은 것이다.
            // 따라서 앞에 B를 빼고 뒤집는다.
            if (curT.charAt(0) == 'B') {
                StringBuilder temp = new StringBuilder(curT);
                temp.delete(0, 1);
                q.add(temp.reverse());
            }

            // 마지막 글자가 A면 A를 뺀다.
            if (curT.charAt(curT.length() - 1) == 'A') {
                curT.delete(curT.length() - 1, curT.length());
                q.add(curT);
            }
        }

        System.out.println(0);
        sc.close();
    }

}
