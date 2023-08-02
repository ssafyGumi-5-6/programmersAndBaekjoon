import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int newScore = sc.nextInt();
        int P = sc.nextInt();
        sc.nextLine();

        int rank = 1; // 태수 랭크
        int count = 0; // 태수보다 앞에 있는 점수 개수
        int[] scores = new int[N];

        for(int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();

            // 태수보다 점수가 크면 rank를 증가한다.
            if(scores[i] > newScore) {
                rank++;
            }

            // 태수보다 점수가 낮으면 반복문을 종료한다.
            if(scores[i] < newScore) {
                // 태수의 앞사람 점수가 태수보다 높으면 지금 입력받은 점수의 rank를 태수 rank로 둔다.
                if(i > 0 && scores[i - 1] > newScore) {
                    rank = i + 1;
                }
                break;
            }
            count++;
        }

        if(count == P) {
            rank = -1;
        }
        System.out.println(rank);
        sc.close();
    }

}
